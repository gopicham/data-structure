package com.thread.safe;

import com.map.hashmap.Entry;

public class Node {
	int data; // Data of the node
	Node next; // Pointer to the next node

	// Constructor to create a new node
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
