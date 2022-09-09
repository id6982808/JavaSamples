import java.util.Scanner;
// https://qiita.com/b150005/items/7a378a0b7ccb0fc08e44

public class ThrowAndCatch {
	static void check(int sw) throws Exception {
		switch (sw) {
			case 0: throw new Exception("This exception has to be catched.");
			case 1: throw new RuntimeException("This exception does not have to be catched.");
		}
	}
	
	static void call(int sw) throws Exception {
		check(sw);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("sw(0 .. checked/1 .. unchecked): ");
		int sw = stdIn.nextInt();
		
		try {
			call(sw);
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
