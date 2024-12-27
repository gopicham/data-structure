/**
 * 
 */
package com.assesment.client;

/**
 * 
 */
public class LinkedList {

	private Node head;
	protected int modCount = 1;

	class Node {
		Node next;
		int data;

		public Node(int data) {
			this.next = null;
			this.data = data;
		}
	}

	public Node addAtSpecificPosition(int data, int pos) {
		Node newNode = new Node(data);
		Node temp = head;
		int cn = 1;
		while (cn < pos - 1) {
			temp = temp.next;
			cn++;
		}
		newNode.next = temp.next;
		temp.next = newNode;

		return head;

	}

	public Node addFirst(int data, int index) {
		Node newNode = new Node(data);
		if (head == null) {
			return head = newNode;
		}
		if (size() <= index) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 1) {
			newNode.next = head;
			return head = newNode;
		}
		int count = 1;
		Node temp = head;
		while (count < index - 1) {
			temp = temp.next;
			count++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return this.head;

	}

	public Node push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			modCount++;
			return head = newNode;
		}
		newNode.next = head;
		head = newNode;
		modCount++;
		return head;
	}

	public void poll() {
		while (head != null) {
			System.out.println("data :" + head.data);
			head = head.next;
		}
	}

	public int size() {
		return modCount;
	}

	public static void main(String... str) {

		LinkedList dat = new LinkedList();
		dat.push(1);
		dat.push(2);
		dat.push(3);
		dat.push(4);
		dat.push(5);
		dat.push(6);
		dat.push(7);
		dat.push(8);
		dat.push(9);
		dat.push(10);

		//dat.addFirst(100, 12);
		dat.poll();
		System.out.println("size of DS :" + dat.size());

	}
}
