
public class QueueUsingLinkedList1 {

	private Node front, rear; // Points to the front and rear of the queue

	// Constructor to initialize the queue
	public QueueUsingLinkedList1() {
		front = rear = null;
	}

	// Method to check if the queue is empty
	public boolean isEmpty() {
		return front == null;
	}

	// Method to enqueue (add) an element to the rear of the queue
	public void enqueue(int data) {
		Node newNode = new Node(data);
		if (rear == null) {
			// If the queue is empty, both front and rear should point to the new node
			front = rear = newNode;
		} else {
			// If the queue is not empty, add the new node at the rear and update rear
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println(data + " enqueued to queue");
	}

	// Method to dequeue (remove) an element from the front of the queue
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1; // Return a default value to indicate an error
		}
		int dequeuedData = front.data; // Get the data from the front node
		front = front.next; // Update the front to the next node

		// If the queue becomes empty, set rear to null
		if (front == null) {
			rear = null;
		}

		return dequeuedData; // Return the dequeued data
	}

	// Method to peek at the front element of the queue
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1; // Return a default value to indicate an error
		}
		return front.data; // Return the data of the front node
	}

	// Method to display the elements of the queue
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		Node current = front;
		System.out.print("Queue elements: ");
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		QueueUsingLinkedList1 queue = new QueueUsingLinkedList1();

		// Enqueue elements into the queue
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		// Display current queue
		queue.display();

		// Peek at the front element of the queue
		System.out.println("Front element is: " + queue.peek());

		// Dequeue elements from the queue
		System.out.println(queue.dequeue() + " dequeued from queue");
		queue.display();

		System.out.println(queue.dequeue() + " dequeued from queue");
		queue.display();

		System.out.println(queue.dequeue() + " dequeued from queue");
		queue.display();

		System.out.println(queue.dequeue() + " dequeued from queue");
		queue.display(); // Display after all elements are dequeued
	}

}
