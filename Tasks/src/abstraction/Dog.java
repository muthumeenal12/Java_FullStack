package abstraction;
import utils.Sound;
public class Dog extends Animal {
//	Override the abstract make sound 
	public void makeSound()
	{
		System.out.println(Sound.Dog);
	}
	public static void main(String[] args) {
//	Create an object for the class dog
		Dog dog = new Dog();
		dog.makeSound();
	}

}
