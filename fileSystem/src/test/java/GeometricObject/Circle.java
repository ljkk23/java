package GeometricObject;

public class Circle extends GeometricObject implements Colorable{
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public Circle(double radius,String color,Boolean isfilled) {
		this.color=color;
		this.filled=isfilled;
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getArea() {
		return Math.PI * radius * radius;
	}
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	@Override
	public void howToColor() {
		System.out.println("Color all 圆形 sides");
	}
}