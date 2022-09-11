// Runnable インタフェースによるスレッド処理

class TestRunnable implements Runnable {
	public void run() {
		System.out.println("スレッド処理");
	}
}

public class SampleRunnableInterface {
	public static void main(String[] args) {
		Runnable runnable = new TestRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
