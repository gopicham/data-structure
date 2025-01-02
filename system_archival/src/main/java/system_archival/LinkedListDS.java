/**
 * 
 */
package com.linked.list;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 */
public final class LinkedListDS extends Object {

	private Node<Object> head;

	// proxy method
	public void add(Object data) {
		Node<Object> newNode = new Node<Object>(data);
		if (head == null) {
			head = newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void insertAtBegin(Object data) {
		Node<Object> newNode = new Node<Object>(data);
		if (head == null) {
			add(data);
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	public void insertAtEnd(Object data) {
		Node<Object> newNode = new Node<Object>(data);

		if (null == head) {
			insertAtBegin(data);
			return;
		}
		Node<Object> cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = newNode;
	}

	public void insertAtSpecificPos(Object data, int pos) {
		Node<Object> newNode = new Node<Object>(data);
		Node<Object> cur = head;
		int count = 0;
		while (count < pos - 1) {
			cur = cur.next;
			count++;
		}
		newNode.next = cur.next;
		cur.next = newNode;
	}

	public void print() {
		Node<Object> cur = head;
		for (; cur != null;) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

//sorting for java.object
	public void sortUsingComp() {
		Node<Object> cur = head;
		List<Object> list = new LinkedList<>();
		while (cur != null) {
			list.add(cur.data);
			cur = cur.next;
		}

		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object t1, Object t2) {
				return t1.toString().compareTo(t2.toString());
			}
		});
		cur = head;
		for (Object data : list) {
			cur.data = data;
			cur = cur.next;
		}
	}

	public void SelectionSort() {

		Node<Object> cur = head;
		Node<Object> prev;
		Object temp;
		while (cur != null) {
			prev = cur;
			while (prev != null) {
				if (cur.data.toString().compareTo(prev.data.toString()) > 0) {
					temp = cur.data;
					cur.data = prev.data;
					prev.data = temp;
				}
				prev = prev.next;
			}
			cur = cur.next;
		}
	}

	public boolean search(Object indexData) {

		Node<Object> temp = head;
		while (temp != null) {
			if (indexData == temp.data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void deleteAtSpecifiedPostion(int pos) 
	{
		Node<Object> temp = head;
		Node<Object> prev = null;
		int count = 0;
		if (pos == 0) {
			head = temp.next;
			return;
		}
		while (count < pos - 1 && temp != null) {
			prev = temp;
			temp = temp.next;
			count++;
		}
		prev.next = temp.next;
		temp.next = prev;
	}

	public void deleteFirst()
	{
		head = head.next;
	}

	public void deleteLast() 
	{
		Node<Object> temp = head;
		Node<Object> prev = null;
		while (temp.next != null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		temp.next = prev;
	}

	public static void main(String[] args) {
		LinkedListDS ds = new LinkedListDS();
		ds.add(40);
		ds.add(10.99);
		ds.add("abc");
		ds.add(90);
		ds.add(80);
		ds.add(99);
		ds.add(11.99);
		ds.add("xyz");
		ds.add(10);
		ds.add(20);
		ds.add(50);
		System.out.println("\n--------------------------------------");
		ds.print();
	
		System.out.println("\n--------------------------------------");
		ds.deleteFirst();
		
		ds.print();
		System.out.println("\n--------------------------------------");
		System.out.println("found : " + ds.search(50));

	}

}
