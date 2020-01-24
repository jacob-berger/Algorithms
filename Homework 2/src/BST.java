
public class BST {

	Node root;
	private class Node {

		public Node left, right;
		public Comparable data;

		public Node(Comparable data) {
			this.data = data;
			left = right = null;
		}

	}

	public BST() {
		root = null;
	}

	public Node insert(Node node, Comparable toInsert) {
		if (node == null) {
			node = new Node(toInsert);
		} else {
			if (toInsert.compareTo(node.data) < 0) {
				node.left = insert(node.left, toInsert);
			} else {
				node.right = insert(node.right, toInsert);
			}
		}

		return node;
	}
	
	public void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		postOrderTraversal(root.left);
		
		postOrderTraversal(root.right);
		
		System.out.println(root.data);
	}
	
	public void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		preOrderTraversal(root.right);
		
		preOrderTraversal(root.left);
		
		System.out.println(root.data);
	}
	
	public void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		
		System.out.println(root.data);
		
		inOrderTraversal(root.right);
	}
	
	public Node deleteHelper(Node root, Comparable toRemove) {
		if (root == null) {
			return root;
		}
        if (toRemove.compareTo(root.data) < 0) {
            root.left = deleteHelper(root.left, toRemove);
        } else if (toRemove.compareTo(root.data) > 0) {
            root.right = deleteHelper(root.right, toRemove);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null)
                return root.left;

            root.data = findSuccessor(root.right);
            root.right = deleteHelper(root.right, root.data);
        }

        return root;

    }

    public static Comparable findSuccessor(Node root) {
        Comparable minimum = root.data;
        while (root.left != null) {
            minimum = root.left.data;
            root = root.left;
        }
        return minimum;
	}
    
    public boolean search(Node root, Comparable toRemove) {
    	
    	while (root != null) {
    		if (toRemove.compareTo(root.data) < 0) {
    			root = root.left;
    		} else if (toRemove.compareTo(root.data) > 0) {
    			root = root.right;
    		} else if (toRemove.compareTo(root.data) == 0) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public boolean delete(Comparable item) {
    	boolean before = search(root, item);
    	deleteHelper(root, item);
    	boolean after = search(root, item);
    	if (before == after) {
    		return false;
    	} else {
    		return true;
    	}
    }
}
