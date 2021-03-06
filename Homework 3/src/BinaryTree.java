
public class BinaryTree {

	private class Node {

		public Node left, right;
		public int data;

		Node(int data) {
			this.data = data;
			left = right = null;
		}

	}

	Node root;
	int index = 0;

	public BinaryTree() {
		root = null;
	}

	public Node insert(int toInsert) {
		return insert(root, toInsert);
	}

	private Node insert(Node root, int toInsert) {
		if (root == null) {
			root = new Node(toInsert);
		} else {
			if (toInsert < root.data) {
				root.left = insert(root.left, toInsert);
			} else {
				root.right = insert(root.right, toInsert);
			}
		}

		return root;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node root) {
		if (root == null) return;

		inOrderTraversal(root.left);

		System.out.println(root.data);

		inOrderTraversal(root.right);
	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node root) {
		if (root == null) return;

		postOrderTraversal(root.left);

		postOrderTraversal(root.right);

		System.out.println(root.data);
	}

	public static BinaryTree buildTree(Object inOrderSequence[], Object postOrderSequence[]) {

		if (inOrderSequence == null || postOrderSequence == null) throw new NullPointerException("Input was null");
		if (inOrderSequence.length == 0) return new BinaryTree();
		if (inOrderSequence.length == 1) {
			BinaryTree tree = new BinaryTree();
			tree.insert((int) inOrderSequence[0]);
			return tree;
		} else {
			Object[] leftInOrder = findLeftSubtreeInOrder(inOrderSequence, (int) postOrderSequence[postOrderSequence.length - 1]);
			Object[] leftPostOrder = findLeftSubtreePostOrder(inOrderSequence, postOrderSequence, (int) postOrderSequence[postOrderSequence.length - 1]);
			Object[] rightInOrder = findRightSubtreeInOrder(inOrderSequence, (int) postOrderSequence[postOrderSequence.length - 1]);
			Object[] rightPostOrder = findRightSubtreePostOrder(inOrderSequence, postOrderSequence, (int) postOrderSequence[postOrderSequence.length - 1]);

			BinaryTree tree = new BinaryTree();
			tree.buildTreeHelper(leftInOrder, leftPostOrder);
			tree.buildTreeHelper(rightInOrder, rightPostOrder);
			return tree;
		}

	}

	private Node buildTreeHelper(Object[] inOrder, Object[] postOrder) {
		if (inOrder == null || postOrder == null) throw new NullPointerException("Input was null");
		if (inOrder.length == 0 || postOrder.length == 0) return null;
		if (inOrder.length == 1 || postOrder.length == 1) {
			this.insert((int)postOrder[0]);
			return null;
		} else {
			Object[] leftInOrder = findLeftSubtreeInOrder(inOrder, (int) postOrder[postOrder.length - 1]);
			Object[] leftPostOrder = findLeftSubtreePostOrder(inOrder, postOrder, (int) postOrder[postOrder.length - 1]);
			Object[] rightInOrder = findRightSubtreeInOrder(inOrder, (int) postOrder[postOrder.length - 1]);
			Object[] rightPostOrder = findRightSubtreePostOrder(inOrder, postOrder, (int) postOrder[postOrder.length - 1]);

			this.buildTreeHelper(leftInOrder, leftPostOrder);
			this.buildTreeHelper(rightInOrder, rightPostOrder);
		}
		return this.root;
	}

	private static Object[] findLeftSubtreeInOrder(Object inOrderSequence[], int root) {
		int ix = 0;
		while ((int) inOrderSequence[ix] != root) {
			ix++;
		}

		Object leftSubtree[] = new Object[ix];
		for (int iy = 0; iy < ix; iy++) {
			leftSubtree[iy] = inOrderSequence[iy];
		}

		return leftSubtree;
	}

	private static Object[] findRightSubtreeInOrder(Object inOrderSequence[], int root) {
		int ix = 0;
		while ((int) inOrderSequence[ix] != root) {
			ix++;
		}

		Object rightSubtree[] = new Object[inOrderSequence.length - ix - 1];
		for (int iy = ix + 1; iy < inOrderSequence.length; iy++) {
			rightSubtree[iy - ix - 1] = inOrderSequence[iy];
		}

		return rightSubtree;
	}

	private static Object[] findLeftSubtreePostOrder(Object inOrderSequence[], Object postOrderSequence[], int root) {
		int ix = 0;
		while ((int) inOrderSequence[ix] != root) {
			ix++;
		}

		Object leftSubtree[] = new Object[ix];
		for (int iy = 0; iy < ix; iy++) {
			leftSubtree[iy] = postOrderSequence[iy];
		}

		return leftSubtree;
	}

	private static Object[] findRightSubtreePostOrder(Object inOrderSequence[], Object postOrderSequence[], int root) {
		int ix = 0;
		while ((int) inOrderSequence[ix] != root) {
			ix++;
		}

		Object rightSubtree[] = new Object[postOrderSequence.length - ix - 1];
		for (int iy = ix; iy < postOrderSequence.length - 1; iy++) {
			rightSubtree[iy - ix] = postOrderSequence[iy];
		}

		return rightSubtree;
	}


	/*
	 * Should probably be:
	 * if array is a single element, insert into a new tree and return the tree
	 * get root from last element of postorder
	 * while array is not empty
	 * 
	 * get left subtree inorder from elements before root in inorder
	 * get left subtree postorder from number of elements before root in inorder
	 * insert root from last element of postorder
	 * 
	 * get right subtree from elements after root in inorder
	 * 
	 */

}
