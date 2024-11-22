package prob05;

public class RectTriangle extends Shape {

	public RectTriangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return this.width * this.height * 0.5;
	}

	@Override
	public double getPerimeter() {
		return this.width + this.height + Math.sqrt(this.width * this.width + this.height * this.height);
	}

}
