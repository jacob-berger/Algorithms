
public class Tester {

	public static void main(String[] args) {

		BST myBST = new BST();
		System.out.println("New BST created, inserting values:");
		myBST.root = myBST.insert(myBST.root, new Integer(8));
		myBST.root = myBST.insert(myBST.root, new Integer(3));
		myBST.root = myBST.insert(myBST.root, new Integer(1));
		myBST.root = myBST.insert(myBST.root, new Integer(6));
		myBST.root = myBST.insert(myBST.root, new Integer(4));
		myBST.root = myBST.insert(myBST.root, new Integer(7));
		myBST.root = myBST.insert(myBST.root, new Integer(10));
		myBST.root = myBST.insert(myBST.root, new Integer(14));
		myBST.root = myBST.insert(myBST.root, new Integer(13));

		System.out.println("\nPrinting in order:");
		myBST.inOrderTraversal(myBST.root);

		System.out.println("\nPrinting post order:");
		myBST.postOrderTraversal(myBST.root);

		System.out.println("\nDeleting 8.");
		System.out.println("Deleted? " + myBST.delete(new Integer(8)));

		System.out.println("Printing in order:");
		myBST.inOrderTraversal(myBST.root);

		System.out.println("\nPrinting post order:");
		myBST.postOrderTraversal(myBST.root);

		System.out.println("\nDeleting 10.");
		System.out.println("Deleted? " + myBST.delete(new Integer(10)));

		System.out.println("Printing in order:");
		myBST.inOrderTraversal(myBST.root);

		System.out.println("\nPrinting post order:");
		myBST.postOrderTraversal(myBST.root);
	}

	/*
	 * Walkthrough of postOrderTraversal for last call
	 * 
	 * 	public void postOrderTraversal(Node root) {
	 * 		if (root == null) {
	 * 			return;
	 * 		}
	 * 
	 * 		postOrderTraversal(root.left);
	 * 		postOrderTraversal(root.right);
	 * 		System.out.println(root.data);
	 * 	}
	 * 
	 * First node is 8. Call postOrder on left child.
	 * Next node is 3. Call postOrder on left child.
	 * Next node is 1. Call postOrder on left child.
	 * Next node is null, so return to previous call (1).
	 * Call postOrder on right child.
	 * Next node is null, so return to previous call(1).
	 * Print node.data and exit method, returning to previous call (3).
	 * Call postOrder on right child.
	 * Next node is 6. Call postOrder on left child.
	 * Next node is 4. Call postOrder on left child.
	 * Next node is null, so return to previous call (4).
	 * Call postOrder on right child.
	 * Next node is null, so return to previous call (4).
	 * Print node.data and exit method, returning to previous call (6).
	 * Call postOrder on right child.
	 * Next node is 7. Call postOrder on left child.
	 * Next node is null, so return to previous call (7).
	 * Call postOrder on right child.
	 * Next node is null, so return to previous call (7).
	 * Print node.data and exit method, returning to previous call (6).
	 * Print node.data and exit method, returning to previous call (3).
	 * Print node.data and exit method, returning to previous call (8).
	 * Call postOrder on right child.
	 * Next node is 10. Call postOrder on left child.
	 * Next node is null, so return to previous call (10).
	 * Call postOrder on right child.
	 * Next node is 14. Call postOrder on left child.
	 * Next node is 13. Call postOrder on left child.
	 * Next node is null, so return to previous call (13).
	 * Call postOrder on right child.
	 * Next node is null, so return to previous call (13).
	 * Print node.data and exit method, returning to previous call (14).
	 * Call postOrder on right child.
	 * Next node is null, so return to previous call (14).
	 * Print node.data and exit method, returning to previous call (10).
	 * Print node.data and exit method, returning to previous call (8).
	 * Print node.data and exit method, returning to the main method.
	 */

}
