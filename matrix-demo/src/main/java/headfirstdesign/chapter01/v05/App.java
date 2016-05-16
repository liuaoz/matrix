package headfirstdesign.chapter01.v05;

public class App {

	public static void main(String[] args) {
		// program to an implementation
		Dog d = new Dog();
		d.makeSound();

		// program to an interface
		Animal a = new Dog();
		a.makeSound();

	}

}
