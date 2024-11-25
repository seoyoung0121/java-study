package prob04;

import java.util.Arrays;

public class MyStack03<T> {
	private int top;
	private T[] buffer;

	@SuppressWarnings("unchecked")
	public MyStack03(int capacity) {
		this.top = 0;
		this.buffer = (T[]) new Object[capacity];
	}

	public void push(T s) {
		try {
			this.buffer[this.top] = s;
			this.top++;
		} catch (Exception e) {
			resize();
			this.buffer[this.top] = s;
			this.top++;
		}

	}

	public T pop() throws MyStackException {
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
