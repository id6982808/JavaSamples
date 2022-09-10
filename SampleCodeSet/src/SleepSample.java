// スレッドをスリープさせる

public class SleepSample extends Thread {
	
	public SleepSample() {
		
	}
	
	public void run() {
		System.out.println("スリープ開始");
		try {
			for (int i=0; i<3; i++) {
				sleep(1000); // 1秒スリープ
				System.out.println(".");
			}
		}
		catch (InterruptedException e) {}
		System.out.println("終了");
	}
	
	public static void main(String[] arg) {
		new SleepSample().start();
	}
}
