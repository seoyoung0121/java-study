package prob04;

import java.util.Arrays;

public class MyStack02 {
	private int top;
	private Object[] buffer;

	public MyStack02(int capacity) {
		this.top = 0;
		this.buffer = new String[capacity];
	}

	public void push(Object s) {
		try {
			this.buffer[this.top] = s;
			this.top++;
		} catch (Exception e) {
			resize();
			this.buffer[this.top] = s;
			this.top++;
		}

	}

	public Object pop() throws MyStackException {
		if (this.top == 0) {
			throw new MyStackException();
		} else {
			top--;
			return this.buffer[this.top];
		}
	}

	public boolean isEmpty() {
		return this.top == 0;
	}

	private void resize() {
		this.buffer = Arrays.copyOf(this.buffer, top + 1);

	}
}
