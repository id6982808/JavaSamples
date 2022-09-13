/***
 * Deep Copy
 * @author nayuf
 *
 */

class SampleCopy2 implements Cloneable {
	String s = "nnn";
	
	// clone メソッドのオーバーライド
	protected Object clone() throws CloneNotSupportedException {
		SampleCopy2 cp = new SampleCopy2();
		cp.s = this.s;
		
		return cp;
	}
}

public class DeepCopyTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		SampleCopy2 cp1 = new SampleCopy2();
		cp1.s = "abc";
		
		SampleCopy2 cp2 = (SampleCopy2)cp1.clone();
		System.out.println("コピー直後の状態");
		System.out.println("cp1.s = " + cp1.s);
		System.out.println("cp2.s = " + cp2.s);
		cp2.s = "xyz";
		System.out.println("コピー先(cp2)のみ値を更新");
		System.out.println("cp1.s = " + cp1.s);
		System.out.println("cp2.s = " + cp2.s);
	}
}
