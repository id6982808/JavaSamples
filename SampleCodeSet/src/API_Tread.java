// スレッドの実行内容を定義する
public class API_Tread extends Thread {
	public static void main(String[] args) {
		// 3つのスレッドを生成する
		for (int i=0; i<3; i++) {
			// スレッドを生成し、開始させる
			new API_Tread("Thread" + i).start();
		}
	}
	
	public API_Tread(String name) {
		super(name);
	}
	
	public void run() {
		for (int i = 0; i < 3; i++) {
			// スレッドの名前とループ回数(0～2)を表示する
			System.out.println(getName() + ":" + i);
		}
	}
}
