/**
 * 
 */
package com.thread.safe;

/**
 * Random insert and access data in
 */
public class LinearLinkedList {

	private Node head;

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public int pop() {
		System.out.println(head.data + " ");
		head = head.next;
		return head.data;
	}

	public Node inserAtSpecificPosition(int data, int pos) {
		Node newNode = new Node(data);

		if (pos == 0) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		int count = 1;
		Node cur = head;
		while (count < pos) {
			cur = cur.next;
			count++;
		}
		newNode.next = cur.next;
		cur.next = newNode;
		return head;
	}

	public Node remove(int index) {

		if (index == 1) {
			head = head.next;
			return head;
		}

		Node cur = head;
		Node prev = null;
		int count = 1;
		while (cur != null && count < index) {
			prev = cur;
			cur = cur.next;
			count++;
		}
		if (prev == null) {
			throw new IllegalStateException("***specified size does not exist***");
		}
		prev.next = cur.next;
		return head;

	}

	public void sortList() {
		// Node current will point to head
		Node current = head;
		Node prev = null;
		int temp;

		if (head == null) {
			return;
		} else {
			while (current != null) {
				// Node index will point to node next to current
				prev = current.next;

				while (prev != null) {
					// If current node's data is greater than index's node data, swap the data
					// between them
					if (current.data > prev.data) {
						temp = current.data;
						current.data = prev.data;
						prev.data = temp;
					}
					prev = prev.next;
				}
				current = current.next;
			}
		}
	}

	public void print() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	public static void main(String[] args) {
		LinearLinkedList ds = new LinearLinkedList();
		ds.push(2);
		ds.push(4);
		ds.push(6);
		ds.push(3);
		ds.push(1);
		ds.push(5);
		ds.sortList();

		ds.print();
	}

}
