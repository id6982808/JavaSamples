/***
 * インタフェースのテスト
 * @author nayuf
 *
 */

interface If1 {
	String s1 = "If1";
	void m1();
}

interface If2 {
	String s2 = "If2";
	void m2();
}

interface If3 extends If1, If2 {
	String s3 = "If3";
	void m3();
}

interface If4 {
	String s4 = "If4";
	void m4();
}

class IfSample implements If3, If4 {
	public void m1() {
		System.out.println("Interface "+ s1 +" の実装");
	}
	
	public void m2() {
		System.out.println("Interface "+ s2 +" の実装");
	}
	
	public void m3() {
		System.out.println("Interface "+ s3 +" の実装");
	}
	
	public void m4() {
		System.out.println("Interface "+ s4 +" の実装");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		IfSample ifsample = new IfSample();
		ifsample.m1();
		ifsample.m2();
		ifsample.m3();
		If4 ifsample4 = new IfSample();
		ifsample4.m4();
		
		If3 ifsample3 = new IfSample();
		ifsample.m3();
		
		If2 ifsample2 = new IfSample();
		ifsample.m4();
	}
}
