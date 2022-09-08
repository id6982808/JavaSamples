// https://qiita.com/b150005/items/7a378a0b7ccb0fc08e44

abstract class Symbol {
	@Override
	public abstract String toString();
}

class Slash extends Symbol {
	@Override
	public String toString() {
		return "/";
	}
}

class Asterisk extends Symbol {
	@Override
	public String toString() {
		return "*";
	}
}

class Abstract {
	public static void main(String[] args) {
		Symbol[] a = {
				new Slash(),
				new Asterisk()
		};
		
		for (Symbol i : a) {
			if (i instanceof Slash) {
				System.out.println("Slash: " + ((Slash) i).toString());
			}
			else if (i instanceof Asterisk) {
				System.out.println("Asterisk: " + ((Asterisk) i).toString());
			}
		}
	}
}
