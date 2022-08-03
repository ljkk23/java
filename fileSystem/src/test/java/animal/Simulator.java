package animal;

public class Simulator {
	public void playSound(Animal animal) {
		System.out.println(animal.getAnimalName()+"的叫声是：");
		animal.cry();
	}
}
