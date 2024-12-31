package com.list.cicular;

public class CircularListMain {

	public static void main(String... str) {

		CircularLinkedList circular = new CircularLinkedList();
		circular.add(10);
		circular.add(40);

		circular.add(130);
		circular.add(140);
		circular.add(150);
		circular.add(170);
		circular.add(20);
		circular.add(30);

		circular.add(50);
		circular.add(70);
		circular.add(60);
		circular.add(80);

		circular.add(90);
		circular.add(110);
		circular.add(120);
		circular.add(100);

		System.out.println("\n----------------------------------------------------------");
		circular.print();
		System.out.println("\n----------------------------------------------------------");
		circular.add(200);

		circular.print();
		// circular.remove(90);
		circular.insertAtGivenNode(300, 0);
		System.out.println("\n----------------------------------------------------------");
		circular.sort();
		circular.print();
		System.out.println("\n----------------------------------------------------------");
		int node = 40;
		System.out.println(
				"\nNode found in circuar search ::**" + circular.search(node) + "**::and searched node:" + node);
	}
}
