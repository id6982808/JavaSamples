import java.util.InputMismatchException;
import java.util.Scanner;

// https://qiita.com/b150005/items/7a378a0b7ccb0fc08e44

public class ExceptionHandler {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		try {
			System.out.print("100 / ");
			
			int n = stdIn.nextInt();
			
			System.out.println("Ans.: " + (100 / n));
		}
		
		catch (InputMismatchException e) {
			System.out.println("Exception: " + e);
			
			String s = stdIn.next();
			
			System.out.println("Omitted: " + s);
		}
		
		catch (ArithmeticException e) {
			System.out.println("Exception: " + e);
		}
		
		finally {
			System.out.println("End of calc.");
		}
	}
}
