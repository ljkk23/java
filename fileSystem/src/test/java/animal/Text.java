package animal;

public class Text {

	public static void main(String[] args) {
		Simulator simulator=new Simulator();
		simulator.playSound(new snack());
		simulator.playSound(new Dog());
		simulator.playSound(new Cat());
	}
}