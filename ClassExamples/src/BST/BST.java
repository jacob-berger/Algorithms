package BST;

import java.util.ArrayList;

public class BST {
	
	Node root;
	
	private class Node {
		public Node left, right;
		public int data;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	public BST() {
		root = null;
	}
	
	public Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data < node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		
		return node;
	}
	
	public Node findLargest(Node root) {
		if (root == null || root.right == null) {
			return root;
		} else {
			return findLargest(root.right);	
		}
	}
	
	public Node findSmallest(Node root) {
		if (root == null || root.left == null) {
			return root;
		} else {
			return findSmallest(root.left);
		}
	}
	
	public void printAllPaths(Node node, ArrayList<Object> path) {
		//path argument stores the partial path from root to the current node
		
		if (node == null) {
			return;
		}
		
		path.add(node.data);
		if (node.left == null && node.right == null) { //leaf
			System.out.println(path);
			return;
		} else {
			printAllPaths(node.left, new ArrayList<Object>(path));
			printAllPaths(node.right, new ArrayList<Object>(path));
		}
	}
	
	/*
	 * 						A
	 * 				B			C
	 * 			D		E			F
	 * 							G
	 * 
	 * 1. ABD
	 * 2. ABE
	 * 3. ACFG
	 */
	
//	public Node removeRoot(Node root) {
//		if (root == null) {
//			return root;
//		}
//		
//		if (root.left != null) {
//			root = removeRoot(root.left);
//		} else if (root.right != null) {
//			
//		}
//	}
	
	/*
	 * Node removeItem(Node root, Object toRemove) {
	 * 
	 * 	if (root == null) {
	 * 		return null;
	 * 	}
	 * 	if (toRemove.compareTo(root.data) == 0) {
	 * 		root = removeRoot(root);
	 * 	}
	 * 	else if (toRemove.compareTo(root.data) < 0) {
	 * 		root.left = removeItem(root.left, toRemove);
	 * 	}
	 * 	else {
	 * 		root.right = removeItem(root.right, toRemove);
	 * 	}
	 * 
	 * 	return root;
	 */
	
	
	
	/*
	 * Best case scenario
	 * Balanced
	 * Complete
	 * Tree depth is log(n) for n elements
	 */

}
