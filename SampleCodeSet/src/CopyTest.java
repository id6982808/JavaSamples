// オブジェクトのコピーテスト
class SampleCopy {
	String s = "nnn";
}

/***
 * Shallow Copy
 * @author nayuf
 *
 */
public class CopyTest {
	public static void main(String[] args) {
		SampleCopy cp1 = new SampleCopy();
		
		cp1.s = "abc";
		SampleCopy cp2 = cp1;
		System.out.println("コピー直後の状態");
		System.out.println("cp1.s = " + cp1.s);
		System.out.println("cp2.s = " + cp2.s);
		
		cp2.s = "xyz";
		System.out.println("コピー先(cp2)のみ値を更新");
		System.out.println("cp1.s = " + cp1.s);
		System.out.println("cp2.s = " + cp2.s);
	}
}
