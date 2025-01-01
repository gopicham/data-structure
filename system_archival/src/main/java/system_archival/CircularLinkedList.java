/**
 * 
 */
package com.list.cicular;

/**
 * A Circular Linked List in Java is a variation of the linked list where the
 * last node points to the first node instead of null, forming a loop. This
 * circular structure allows you to traverse the list from any node, making it
 * useful in applications like round-robin scheduling.
 */
public class CircularLinkedList {

	private Node head;

	private Node tail;// pointer to head

	/**
	 * @param head
	 * @param tail
	 */
	public CircularLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(int data) {
		final Node newNode = new Node(data);

		if (head == null) {
			tail = head = newNode;
			tail.next = head;
			return;
		}
		tail.next = newNode;
		tail = newNode;
		tail.next = head;
	}

	public void print() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
			if (temp == head) {
				break;
			}
		}
	}

	public void remove(int indexNode) {

		Node current = head;
		Node prev = null;
		if (head.data == indexNode) {
			if (head == tail) {
				head = tail = null;
				return;
			} else {
				prev = tail;
				head = head.next;
				prev.next = head;
				return;
			}
		}
		while (current != null) {
			if (current.data == indexNode) {
				prev.next = current.next; // Skip the current node
				if (current == tail) {
					tail = prev; // Update tail if we deleted the last node
				}
				break;
			}
			prev = current;
			current = current.next;
		}
		return;
	}

	public boolean search(int data) {
		Node temp = head;
		while (temp != null) {
			if (data == temp.data) {
				return true;
			}
			temp = temp.next;
			if (temp == head)
				break;
		}
		return false;

	}

	public void insertAtGivenNode(int data, int pos) {

		Node newNode = new Node(data);

		if (head == null || pos == 0) {
			if (head == null)
				add(data);
			else
				newNode.next = head;
			head = newNode;
			tail.next = head;
			return;
		}

		Node cur = head;
		int count = 0;
		while (count < pos - 1) {
			cur = cur.next;
			count++;
		}
		newNode.next = cur.next;
		cur.next = newNode;
	}

	public Node sort() {
		Node cur = head;
		Node prev;
		int temp;
		while (cur != null) {
			prev = cur;
			while (prev != null) {
				if (cur.data < prev.data) {
					temp = cur.data;
					cur.data = prev.data;
					prev.data = temp;
				}
				prev = prev.next;
				if (prev == cur) {
					break;
				}
			}
			cur = cur.next;
			if (cur == head) {
				break;
			}
		}
		return cur;
	}
}
