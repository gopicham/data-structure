/**
 * 
 */
package com.thread.safe;

/**
 * fifo ---add tail --remove front
 */
public class FixedQueue {

	private int[] queue;
	private int tail;
	private int front;

	/**
	 * @param queue
	 * @param tail
	 * @param front
	 */
	public FixedQueue(int queuSize) {
		this.queue = new int[queuSize];
		this.tail = 0;
		this.front = 0;
	}

	public boolean isEmpty() {
		return queue.length == 0;
	}

	public boolean isFull() {
		return tail == queue.length;
	}

	public void enQueue(int data) {
		if (isFull()) {
			throw new ArrayIndexOutOfBoundsException("***Queue is full***" + tail);
		}
		queue[tail] = data;
		tail++;
	}

	public int size() {
		return tail;
	}

	public int deQueue() {
		int data = queue[front];
		queue[front] = 0;
		tail--;
		front++;
		return data;
	}

	public int peek() {
		return queue[front];

	}

	public void print() {
		while (tail > 0) {
			int pop = queue[front];
			tail--;
			front++;
			System.out.print(pop + " ");

		}
	}

	public static void main(String[] args) {

		FixedQueue qu = new FixedQueue(21);
		qu.enQueue(20);
		qu.enQueue(30);
		qu.enQueue(50);
		qu.enQueue(60);
		qu.enQueue(20);
		qu.enQueue(30);
		qu.enQueue(50);
		qu.enQueue(60);
		qu.enQueue(20);
		qu.enQueue(30);
		qu.enQueue(50);
		qu.enQueue(60);
		qu.enQueue(20);
		qu.enQueue(30);
		qu.enQueue(50);
		qu.enQueue(60);
		qu.enQueue(20);
		qu.enQueue(30);
		qu.enQueue(100);
		qu.enQueue(120);
		qu.enQueue(130);
		System.out.println("size of the queue :" + qu.size());
		qu.deQueue();
		qu.deQueue();
		qu.deQueue();
		qu.deQueue();
		qu.deQueue();
		qu.deQueue();
		System.out.println("peeked element : " + qu.peek());
		qu.deQueue();
		System.out.println("peeked element : " + qu.peek());
		System.out.println("size of the queue :" + qu.size());
		qu.print();

	}

}
