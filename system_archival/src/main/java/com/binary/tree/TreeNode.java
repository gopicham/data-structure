/**
 * 
 */
package com.binary.tree;

import java.util.Queue;

import com.assesment.client.LinkedList;

/**
 * 
 */
public class TreeNode {

	private Node root;

	public TreeNode() {
		this.root = null;
	}

	// proxy methods starts
	public int size() {
		return size(root);
	}

	public int findMin() {
		return findMin(root);
	}

	public int findMax() {
		return findMax(root);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	public void preTransversal() {
		preOrderTrans(root);
	}

	public void inOrderTrans() {
		inOrderTrans(root);
	}

	public void postOrderTrans() {
		postOrderTrans(root);
	}

	public boolean search(int toBeSearched) {
		return search(root, toBeSearched);
	}

	public void delete(int toBeDeleted) {
		delete(root, toBeDeleted);
	}

	// proxy methods ends

	public Node insert(Node root, int data) {

		if (null == root) {
			return root = new Node(data);
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		} else if (data > root.data) {
			root.right = insert(root.right, data);
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

	public Node postOrderTrans(Node root) {
		if (root == null) {
			return root;
		}
		inOrderTrans(root.left);
		inOrderTrans(root.right);
		System.out.print(root.data + " ");
		return root;

	}

	public boolean search(Node root, int toBeSearched) {
		boolean isfound;
		if (root == null) {
			return false;
		}
		if (toBeSearched < root.data) {
			isfound = search(root.left, toBeSearched);
		} else if ((toBeSearched > root.data)) {
			isfound = search(root.right, toBeSearched);
		} else
			isfound = true;// equals then

		return isfound;
	}

	public int size(Node root) {
		if (root == null) {
			return 0;
		}
		int left = size(root.left);
		int right = size(root.right) + 1;

		return left + right;

	}

	public Node delete(Node root, int toBeDeleted) {

		if (root == null) {
			return root;
		}

		if (toBeDeleted < root.data) {
			root.left = delete(root.left, toBeDeleted);
		} else if (toBeDeleted > root.data) {
			root.right = delete(root.right, toBeDeleted);
		} else {
			if (root.left == null) {
				root = root.right;
			} else if (root.right == null) {
				root = root.left;
			}
		}
		return root;
	}

	public int findMin(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.data;

	}

	public int findMax(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root.data;
	}

	public void mirror() {
		mirror(root);
	}

	// swap each node
	public Node mirror(Node root) {

		if (root == null) {
			return root;
		}
		Node cur = root.left;

		root.left = root.right;
		root.right = cur;

		mirror(root.left);
		mirror(root.right);

		return root;
	}

	public Node levelOrderTrans() {
		return levelOrderTrans(root);
	}

//done based on queue FIFO
	public Node levelOrderTrans(Node root) {

		Queue<Node> qu = new java.util.LinkedList<Node>();
		qu.add(root);

		while (!qu.isEmpty()) {
			Node cur = qu.poll();
			System.out.print(cur.data + " ");
			if (cur.left != null) {
				qu.add(cur.left);
			}
			if (cur.right != null) {
				qu.add(cur.right);
			}

		}
		return root;

	}

	public static void main(String[] args) {
		TreeNode nd = new TreeNode();
		nd.insert(30);
		nd.insert(50);
		nd.insert(60);
		nd.insert(90);
		nd.insert(70);
		nd.insert(100);
		nd.insert(10);
		nd.insert(20);
		System.out.print("\nlevelOrd:");
		nd.levelOrderTrans();
		System.out.print("\npOrdr:");
		nd.preTransversal();
		System.out.print("\norder:");
		nd.inOrderTrans();
		// nd.delete(60);
		System.out.print("\npostd:");
		nd.postOrderTrans();

		int search = 50;

		System.out.print("\nelement to search::" + search + "::found ::" + nd.search(search));
		System.out.println(
				"\nMin value :" + nd.findMin() + " and Max value :" + nd.findMax() + " and size of Tree:" + nd.size());

		System.out.print("\nswap:");
		nd.mirror();
		System.out.print("\npostd:");
		nd.postOrderTrans();
		
		System.out.print("\npostd:");
		nd.postOrderTrans();
		System.out.print("\nlevel:");
		nd.delete(100);
		nd.levelOrderTrans();
		
	
	}

}
