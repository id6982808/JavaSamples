// スレッドを開始する

public class THThreadSample {
	public static void main(String[] args) {
		LockObj obj = new LockObj();
		new GetThread(obj).start();
		new SetThread(obj).start();
	}
}

class SetThread extends Thread {
	LockObj obj;
	
	SetThread(LockObj obj) {
		this.obj = obj;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			this.obj.setValue(i);
			System.out.println("SET:"+i);
			try {
				Thread.sleep((int)(Math.random() * 1000));
			}
			catch (InterruptedException e) {}
		}
	}
}

class GetThread extends Thread {
	LockObj obj;
	
	GetThread(LockObj obj) {
		this.obj = obj;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("GET:"+this.obj.getValue());
		}
	}
}

class LockObj {
	private int value;
	private boolean flag = false;
	
	public synchronized void setValue(int v) {
		while (this.flag == true) {
			try { wait(); }
			catch (InterruptedException e) { }
		}
		value = v;
		flag = true;
		notifyAll();
	}
	
	public synchronized int getValue() {
		while(flag == false) {
			try { wait(); }
			catch (InterruptedException e) { }
		}
		flag = false;
		notifyAll();
		return value;
	}
}
