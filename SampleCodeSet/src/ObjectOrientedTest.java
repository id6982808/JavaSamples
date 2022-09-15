/***
 * オブジェクト指向の特性
 * @author nayuf
 *
 */

class Animal01 {
	public void eat(String food) {
		System.out.println(food + "を食べました。");
	}
}

class Cat01 extends Animal01 {
	private final String CRY = "ニャンニャンニャン";
	public void bark() {
		System.out.println("ねこ : " + CRY);
	}
}

class PetCare {
	public static void giveBait(Animal01 animal) {
		animal.eat("エサ");
	}
}

public class ObjectOrientedTest {
	public static void main(String[] args) {
		Cat01 pet = new Cat01();
		PetCare.giveBait(pet);
	}
}
