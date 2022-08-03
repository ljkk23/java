package animal;

public class Cat implements Animal{

	public void cry() {
		System.out.println("喵喵喵");
	}

	public String getAnimalName() {
		return "猫";
	}
}