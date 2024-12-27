/**
 * 
 */
package com.thread.safe;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * LIFO -Last-In-First-Out
 */
public class LinkedListStack {

	private Node front;

	private int size;

	/**
	 * @param front
	 * @param size
	 */
	public LinkedListStack() {
		this.front = null;
		this.size = 0;
	}

	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = front;
		front = newNode;
		size++;
	}

	public int pop() {
		int data = front.data;
		System.out.println("popped data :" + data + " ");
		front = front.next;
		size--;
		return data;
	}

	public int peek() {
		System.out.println("peeked data :" + front.data + " ");
		return front.data;
	}

	public int size() {
		return size;
	}

	public void print() {
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public List<Integer> sortUsingList() {

		List<Integer> list = new LinkedList<Integer>();
		while (front != null) {
			list.add(front.data);
			front = front.next;
		}
		Collections.sort(list);
		int count = list.size() - 1;
		for (int i = 0; i < list.size(); i++) {
			this.push(list.get(count--));
		}
		return list;
	}

	public void sort() {
		Node cur = front;
		Node prev;
		int temp; // to hold the prev data

		while (cur != null) {
			prev = cur.next;
			while (prev != null) {
				if (cur.data < prev.data) {
					temp = cur.data;
					cur.data = prev.data;
					prev.data = temp;
				}
				prev = prev.next;
			}
			cur = cur.next;
		}
	}

	public void sortNaturalOrder() {

		Node cur = front;
		Node prev;
		int temp = 0; // to hold prev data
		for (; cur != null;) {
			prev = cur.next;

			for (; prev != null;) {
				if (cur.data > prev.data) {
					temp = cur.data;
					cur.data = prev.data;
					prev.data = temp;
				}
				prev = prev.next;
			}
			cur = cur.next;
		}

	}

	public void sortArry() {
		int temp = 0;
		int[] arr = { 70, 10, 30, 50, 20, 60, 90 };
		Arrays.stream(arr).forEach(t -> System.out.print(" " + t + " " + "::"));
		System.out.print("\n");
		for (int i = 0; i < arr.length; i++) {
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[i] > arr[k]) {
					temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(t -> System.out.print(" " + t + " " + "::"));
	}

	public static void main(String[] args) {

		LinkedListStack dynamicStack = new LinkedListStack();
		dynamicStack.push(70);
		dynamicStack.push(40);
		dynamicStack.push(20);
		dynamicStack.push(100);
		dynamicStack.push(30);
		dynamicStack.push(50);
		dynamicStack.push(10);

		dynamicStack.sortNaturalOrder();
		System.out.print("\n");
		dynamicStack.print();

	}

}
