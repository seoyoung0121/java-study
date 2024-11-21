package prob06;

public class Div {
	private int lValue;
	private int rValue;

	public void setValue(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public int calculate() {
		if (this.rValue == 0) {
			return 0; // 일단 0으로 처
		}
		return this.lValue / this.rValue;
	}
}
