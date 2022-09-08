// https://qiita.com/b150005/items/7a378a0b7ccb0fc08e44

class Super {
	private String name;
	
	// コンストラクタ
	public Super(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println(getName() + ": Super");
	}
}

class Sub extends Super {
	// コンストラクタ
	public Sub(String name) {
		super(name);
	}
	
	// オーバーライド
	@Override
	public void print() {
		System.out.println(getName() + ": sub");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		Sub sub = new Sub("Super or Sub");
		
		Super sup = sub;
		
		sup.print();
		
		Super[] a = {
			new Super("Super 1"),
			new Super("Super 2"),
			new Sub("Sub 1"),
			new Sub("Sub 2")
		};
		
		for (Super i : a) {
			if (i instanceof Sub) {
				((Sub) i).print();
			}
			else {
				i.print();
			}
		}
	}
}
