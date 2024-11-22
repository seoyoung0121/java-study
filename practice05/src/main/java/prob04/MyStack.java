package prob04;

import java.util.Arrays;

public class MyStack {
	private int top;
	private String[] buffer;

	public MyStack(int capacity) {
		this.top = 0;
		this.buffer = new String[capacity];
	}

	public void push(String s) {
		try {
			this.buffer[this.top] = s;
			this.top++;
		} catch (Exception e) {
			resize();
			this.buffer[this.top] = s;
			this.top++;
		}

	}

	public String pop() throws MyStackException {
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