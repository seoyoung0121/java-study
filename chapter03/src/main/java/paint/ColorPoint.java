package paint;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
		super(x, y);
//		setX(x);
//		setY(y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public void show() {
		System.out.println("Point[x=" + getX() + ", y=" + getY() + ", color=" + color + "]를 그렸습니다.");
		// x, y 로 하면 오류남, getter를 쓰거나 protected로 바꿈
	}
	
	@Override
	public void draw() {
		show();
		// super.draw();
		// 이거도 똑같음, 맨 밑에있는 show 부름
	}

}
