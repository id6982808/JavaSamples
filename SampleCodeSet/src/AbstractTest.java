/***
 * 抽象クラステスト
 * @author nayuf
 *
 */
abstract class Employee {
	protected String name = "社員";
	
	abstract void work();
	
	public void goOffice() {
		System.out.println(name + "が出社しました。");
	}
	
	public void goHome() {
		System.out.println(name + "が帰宅しました。");
	}
}

class SalesMan extends Employee {
	public SalesMan(String name) {
		super.name = name;
	}
	
	public void work() {
		System.out.println("営業の仕事を行います。");
	}
}

class Developer extends Employee {
	public Developer(String name) {
		super.name = name;
	}
	
	public void work() {
		System.out.println("開発の仕事を行います。");
	}
}

class GeneralManager extends Employee {
	public GeneralManager(String name) {
		super.name = name;
	}
	
	public void work() {
		System.out.println("総務の仕事を行います。");
	}
}

public class AbstractTest {
	public static void main(String[] args) {
		Employee sm = new SalesMan("営業部の社員A");
		Employee dp = new Developer("開発部の社員B");
		Employee gm = new GeneralManager("総務部の社員C");
		
		// 出社
		sm.goOffice();
		dp.goOffice();
		gm.goOffice();
		// 業務
		sm.work();
		dp.work();
		gm.work();
		// 帰宅
		sm.goHome();
		dp.goHome();
		gm.goHome();
	}
}
