package BST;

import java.util.ArrayList;

public class Tester {

	public static void main(String args[]) {
		BST tree = new BST();
		
		tree.root = tree.insert(tree.root, 6);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 7);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 4);
		tree.root = tree.insert(tree.root, 1);
		tree.root = tree.insert(tree.root, 2);
		tree.root = tree.insert(tree.root, 5);
		
		tree.printAllPaths(tree.root, new ArrayList<Object>());
	}
}
