package GeometricObject;

public class Rectangle extends GeometricObject implements Colorable{
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	public Rectangle(double height, double width,String color,Boolean filled) {
		this.color=color;
		this.filled=filled;
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getArea() {
		return height * width;
	}
	public double getPerimeter() {
		return 2 * (height + width);
	}

	@Override
	public void howToColor() {
		System.out.println("Color all 矩形 sides");
	}
}