package GeometricObject;

import java.util.Scanner;

public class oneTest {
	public static double sumArea(GeometricObject[] object) {
		return object[0].getArea() + object[1].getArea() + object[2].getArea();
	}
	public static void main(String[] args) {
		GeometricObject[] object = new GeometricObject[3];  //创建图形数组
		object [0] = new Rectangle(5,6);
		System.out.println("矩形的面积"+object[0].getArea());
		object [1] = new Triangle(3,4,5);
		System.out.println("三角形的面积"+object[1].getArea());
		object [2] = new Circle(5);
		System.out.println("圆形的面积"+object[2].getArea());
		System.out.println("三个图形的总面积为：" + sumArea(object));
	}
}
