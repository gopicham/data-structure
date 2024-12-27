/**
 * 
 */
package com.thread.safe;

/**
 * FIFO--Put in tail and take out from head
 */
public class QueueNode {

	private Node front, tail;

	private int size;

	public QueueNode() {
		this.front = null;
		this.tail = null;
		this.size = 0;
	}

	public Node enQueue(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = tail = newNode;
		} else
			tail.next = newNode;
		tail = newNode;
		return tail;
	}

	public int deQueue() {
		System.out.print("enqueued element :");
		int popped = front.data;
		front = front.next;
		System.out.print(popped + " ");
		if (front == null) {
			tail = null;
		}

		return popped;
	}

	public int peek() {
		System.out.println("peeked  :" + front.data);
		return front.data;
	}

	public void print() {
		System.out.print("\nqueue elements are :");
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public int size() {
		Node temp = front;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		return size;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public static void main(String[] args) {

		QueueNode nd = new QueueNode();
		nd.enQueue(10);
		nd.enQueue(40);
		nd.enQueue(20);
		nd.enQueue(30);
		nd.enQueue(10);
		nd.enQueue(40);
		nd.enQueue(20);
		nd.enQueue(30);
		nd.deQueue();
		
		System.out.println("\nqueue size: " + nd.size());
		nd.print();

	}

}
