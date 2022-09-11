
class Sheet {
	private boolean vacant = true;
	
	public synchronized void reserve(String name) {
		try {
			if (vacant == true) {
				System.out.println(name + " が予約確認：シート予約確認です。");
				System.out.println(name + " の予約処理中・・・");
				Thread.sleep(1000);
				vacant = false;
				System.out.println(name + " のシート予約が完了しました。");
			} else {
				System.out.println(name + " が予約確認：予約済みです。");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class SampleSynchronized extends Thread {
	static Sheet sheet;
	public static void main(String[] args) {
		sheet = new Sheet();
		
		Thread thread1 = new SampleSynchronized();
		Thread thread2 = new SampleSynchronized();
		thread1.start();
		thread2.start();
	}
	public void run() {
		sheet.reserve(this.getName());
	}
}
