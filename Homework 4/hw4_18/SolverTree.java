import java.util.Arrays;

public class SolverTree {
	
	Node root;
	
	public class Node {
		char c;
		Node c1, c2, c3, c4 = null;
		
		
		public Node(char c) {
			this.c = c;
			c1 = null;
			c2 = null;
			c3 = null;
			c4 = null;
		}

	}
	
	public SolverTree() {
		this.root = new Node(' ');
	}
	
	public void buildSolver(int[] digits, Node cur) {
		
		if (digits == null || digits.length == 0) {
			return;
		}
		
		int firstDigit = digits[0];
		createNodes(firstDigit, cur);
		buildSolver(Arrays.copyOfRange(digits, 1, digits.length), cur.c1);
		buildSolver(Arrays.copyOfRange(digits, 1, digits.length), cur.c2);
		buildSolver(Arrays.copyOfRange(digits, 1, digits.length), cur.c3);
		if (digits[0] == 7 || digits[0] == 9) {
			buildSolver(Arrays.copyOfRange(digits, 1, digits.length), cur.c4);
		}
		
	}
	
	public void createNodes(int digit, Node cur) {
		switch (digit) {
		case 2:
			cur.c1 = new Node('a');
			cur.c2 = new Node('b');
			cur.c3 = new Node('c');
			break;
		case 3:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			break;
		case 4:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			break;
		case 5:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			break;
		case 6:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			break;
		case 7:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			cur.c4 = new Node('s');
			break;
		case 8:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			break;
		case 9:
			cur.c1 = new Node('d');
			cur.c2 = new Node('e');
			cur.c3 = new Node('f');
			cur.c4 = new Node('s');
			break;
		default:
			throw new IllegalArgumentException("Digits 0 and 1 are not valid here.");
		}
	}
	
	public void printAllWords() {
		printAllWords(root, "");
	}
	
	private String printAllWords(Node root, String s) {
		if (root == null) {
			return s;
		}
		
		String string;
		if (root.c1 == null) {
			return s + root.c;
		} else {
			string = s + root.c;
		}
		
		Node cur = root.c1;
		string = printAllWords(cur, string);
		cur = root.c2;
		string = printAllWords(cur, string);
		cur = root.c3;
		string = printAllWords(cur, string);
		if (root.c4 != null) {
			cur = root.c4;
			string = printAllWords(cur, string);
		}
		return string;
	}
	
	
	public static void main(String[] args) {
		SolverTree tree = new SolverTree();
		DictHashTable table = new DictHashTable();
		int[] array = {3, 5, 4};
		tree.buildSolver(array, tree.root);
		tree.printAllWords();
		
	}

}
