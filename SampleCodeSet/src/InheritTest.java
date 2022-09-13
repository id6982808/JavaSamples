/***
 * 継承テスト
 * @author nayuf
 *
 */

class Parent001 {
	public String ps1 = "親クラスのメンバ変数が参照されました。";
	public Parent001() {
		System.out.println("親クラスのコンストラクタ（引数なし）が呼ばれました。");
	}
	public void pm() {
		System.out.println("親クラスのメソッドが呼ばれました。");
	}
}

class Child001 extends Parent001 {
	public String cs1 = "子クラスのメンバ変数が参照されました。";
	public Child001() {
		System.out.println("自クラスのコンストラクタ(引数なし)が呼ばれました。");
	}
	public void cm() {
		System.out.println("子クラスのメソッドが呼ばれました。");
	}
}

public class InheritTest {
	public static void main(String[] args) {
		Child001 child = new Child001();
		System.out.println(child.ps1);
		System.out.println(child.cs1);
		child.pm();
		child.cm();
	}
}
