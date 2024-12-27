/**
 * 
 */
package com.thread.safe;

import java.util.LinkedList;
import java.util.Queue;
import com.binary.tree.Node;

//Non-linear data structure i.e Tree Map
public class BinaryTree {

	private Node root;

	// proxy methods

	/**
	 * @param root
	 */
	public BinaryTree() {
		this.root = null;
	}

	public void insertCell(int data) {
		root = insertCell(root, data);
	}

	public void preOrderTrans() {
		preOrderTrans(root);
	}

	public void inOrderTrans() {
		inOrderTrans(root);
	}

	public void postOderTrans() {
		postOderTrans(root);
	}

	public int size() {
		return size(root);
	}

	public Node insertCell(Node root, int data) {

		if (root == null) {
			return root = new Node(data);
		}
		if (data < root.data) {
			root.left = insertCell(root.left, data);
		} else if (data > root.data) {
			root.right = insertCell(root.right, data);
		}
		return root;
	}

	public Node preOrderTrans(Node root) {

		if (root == null) {
			return root;
		}
		System.out.print(root.data + " ");
		preOrderTrans(root.left);
		preOrderTrans(root.right);
		return root;
	}

	public Node inOrderTrans(Node root) {
		if (root == null) {
			return root;
		}
		inOrderTrans(root.left);
		System.out.print(root.data + " ");
		inOrderTrans(root.right);
		return root;

	}

	public Node postOderTrans(Node root) {

		if (root == null) {
			return root;
		}
		postOderTrans(root.left);
		postOderTrans(root.right);
		System.out.print(root.data + " ");
		return root;
	}

	public int size(Node root) {
		if (root == null) {
			return 0;
		}
		int left = size(root.left);
		int right = size(root.right);
		return left + right + 1;
	}

	public boolean search(int search) {
		return search(root, search);
	}

	public boolean search(Node root, int search) {

		boolean found = false;
		if (root == null) {
			return false;
		}
		if (search > root.data) {
			found = search(root.left, search);
		} else if (search < root.data) {
			found = search(root.right, search);
		} else
			found = true; // equals case
		return found;
	}

	public void levelOrderTrans() {
		levelOrderTrans(root);
	}

//can be implemented using queue i.e typically applied to trees (like binary trees) and involves visiting nodes level by level.
	public void levelOrderTrans(Node root) {
		Queue<Node> qu = new LinkedList<Node>();
		qu.add(root);

		while (!qu.isEmpty()) {
			Node currentNode = qu.poll();

			System.out.print(currentNode.data + " ");
			if (currentNode.left != null) {
				qu.add(currentNode.left);
			}
			if (currentNode.right != null) {
				qu.add(currentNode.right);
			}
		}
	}

	public void delete(int index) {
		delete(root, index);
	}

	public Node delete(Node root, int index) {
		if (root == null) {
			return root;
		}
		if (index < root.data) {
			root.left = delete(root.left, index);
		} else if (index > root.data) {
			root.right = delete(root.right, index);
		} else {
			if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertCell(10);
		tree.insertCell(30);
		tree.insertCell(20);
		tree.insertCell(50);
		tree.insertCell(40);
		tree.insertCell(60);
		tree.insertCell(70);
		tree.insertCell(100);

		System.out.print("\npreOrdr :");
		tree.preOrderTrans();
		System.out.print("\nInorder :");
		tree.inOrderTrans();
		System.out.print("\npstOrder:");
		tree.postOderTrans();
		System.out.print("\nsize:" + tree.size());

		int search = 70;
		System.out.println("\nsearch a given data : " + search + "::found::" + tree.search(search));

		System.out.print("\nlevlOrdr:");
		tree.delete(70);
		tree.levelOrderTrans();
	}

}
