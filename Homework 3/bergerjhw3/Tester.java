
public class Tester {
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.root = tree.insert(5);
		tree.root = tree.insert(6);
		tree.root = tree.insert(2);
		tree.root = tree.insert(3);
		tree.root = tree.insert(8);
		tree.root = tree.insert(1);
		tree.root = tree.insert(9);
		tree.root = tree.insert(4);
		tree.root = tree.insert(7);
		
		System.out.println("Printing in order:\n");
		tree.inOrderTraversal();
		System.out.println("Printing post order:\n");
		tree.postOrderTraversal();
		System.out.println();
		
		Object inOrder[] = {9, 5, 1, 7, 2, 12, 8, 4, 3, 11};
		Object postOrder[] = {9, 1, 2, 12, 7, 5, 3, 11, 4, 8};
		
		BinaryTree newTree = BinaryTree.buildTree(inOrder, postOrder);
		System.out.println("Printing new tree in order:\n");
		newTree.inOrderTraversal();
		System.out.println("Printing new tree post order:\n");
		newTree.postOrderTraversal();
	}

}
