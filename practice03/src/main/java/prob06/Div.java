package prob06;

public class Div {
	private int lValue;
	private int rValue;

	public void setValue(int lValue, int rValue) {
		this.lValue = lValue;
		this.rValue = rValue;
	}

	public int calculate() {
		return this.lValue / this.rValue;
	}
}
