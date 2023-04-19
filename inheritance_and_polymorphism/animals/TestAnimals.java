public class TestAnimals{
	public static void main(String[] args){
		Dog fido = new Dog("fido" );
		Cat elmo = new Cat("elmo" );


		Animal[] animals = new Animal[2];
		animals[0] = fido;
		animals[1] = elmo;

		for (Animal animal: animals){
			animal.makeSound();
		}
	}
}