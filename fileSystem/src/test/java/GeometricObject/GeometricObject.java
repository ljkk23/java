package GeometricObject;

import java.util.Date;

public abstract class GeometricObject {
	public String color;
	public Boolean filled;
	public Date dateCreated;

	public abstract double getArea();
	public abstract double getPerimeter();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getFilled() {
		return filled;
	}

	public void setFilled(Boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


}