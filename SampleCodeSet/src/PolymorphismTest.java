/***
 * ポリモーフィズム
 * @author nayuf
 *
 */

class Pet {
	public static Animal[] getAnimal() {
		Animal[] animals = {new Cat(), new Dog(), new Frog(), new Duck()};
		return animals;
	}
}

abstract class Animal {
	public abstract void bark();
}

class Cat extends Animal {
	public void bark() {
		System.out.println("ねこ：ニャンニャンニャン");
	}
}

class Dog extends Animal {
	public void bark() {
		System.out.println("いぬ：ワンワンワン");
	}
}

class Frog extends Animal {
	public void bark() {
		System.out.println("かえる：ガァーガァーガァー");
	}
}

class Duck extends Animal {
	public void bark() {
		System.out.println("あひる：がぁーがぁーがぁー");
	}
}

public class PolymorphismTest {
	public static void main (String[] args) {
		Animal[] animal = Pet.getAnimal();
		for (Animal pet : animal) {
			pet.bark();
		}
	}
}
