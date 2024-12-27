/**
 * 
 */
package com.thread.safe;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 
 */
public class AtomicStack {

	private AtomicReference<Node> top;

	private int size;

	public AtomicStack() {
		this.top = new AtomicReference<Node>();
		this.size = 0;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		Node oldNode;
		do {
			newNode.next = oldNode = top.get();
		} while (!top.compareAndSet(oldNode, newNode));
		size++;
	}

	public int pop() {
		Node old;
		Node newTop;
		do {
			old = top.get();
			if (old == null) {
				return -1;
			}
			newTop = old.next;
		} while (!top.compareAndSet(old, newTop));
		size--;
		return old.data;

	}

	public void print() {
		Node temp = top.get();
		while (temp != null) {
			System.out.print(temp.data);
			temp = temp.next;
		}
	}

	public int peek() {
		Node cur = top.get();
		return cur.data;
	}

	public int size() {
		return size;

	}

	public static void main(String... str) {

		AtomicStack mockStack = new AtomicStack();
		mockStack.push(10);
		mockStack.push(20);
		mockStack.push(30);
		mockStack.pop();
		mockStack.peek();
		mockStack.pop();
		mockStack.print();

	}

}
