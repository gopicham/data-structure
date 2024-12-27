/**
 * 
 */
package com.thread.safe;

/**
 * LIFO -add fron front and take out from front
 */
public class FixedStack {
	private int[] stack;

	private int front;

	/**
	 * @param stack
	 * @param front
	 */
	public FixedStack(int fixedSize) {
		this.stack = new int[fixedSize];
		this.front = 0;
	}

	public boolean isEmpty() {
		return front == 0;
	}

	public void push(int data) {
		if (isFull()) {
			throw new IllegalStateException("****Stack is full*****" + front);
		}
		stack[front] = data;
		front++;
	}

//1>2>3>4>5
	public int pop() {
		if (isEmpty())
			throw new IllegalStateException("***stack is empty**");
		front--;
		int data = stack[front];
		stack[front] = 0;

		return data;
	}

	public void print() {
		while (front > 0) {
			front--;
			int data = stack[front];
			System.out.print(data + " ");
		}
	}

	public int peek() {
		return stack[front - 1];
	}

	public boolean isFull() {
		return front == stack.length;
	}

	public int size() {
		return front;
	}

	public static void main(String[] args) {

		FixedStack st = new FixedStack(11);

		st.push(10);
		st.push(40);
		st.push(20);
		st.push(50);
		st.push(10);
		st.push(40);
		st.push(20);
		st.push(50);
		st.push(40);
		st.push(20);
		st.push(50);
		System.out.println("stack size : " + st.size());
		st.pop();
		st.pop();
		st.pop();
		System.out.println("stack size : " + st.size());
		System.out.println("peeeeeek :" + st.peek());
		st.pop();
		System.out.println("peeeeeek :" + st.peek());
		st.pop();
		st.print();

	}

}
