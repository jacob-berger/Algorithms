import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DictPrefixTree {
	
	class TrieNode {
		boolean word = false;
		Map<Character, TrieNode> children = new TreeMap<>();
	}
	
	private TrieNode root;
	
	public DictPrefixTree() {
		this.root = new TrieNode();
		File fin = new File("dictionary.txt");
		readWords(fin);
	}
	
	public void readWords(File file) {
		try {
			Scanner fin = new Scanner(file);
			while (fin.hasNext()) {
				String string = fin.nextLine().split(",")[0];
				insertString(string);
			}
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertString(String s) {
		insertString(root, s);
	}
	
	private void insertString(TrieNode root, String s) {
		TrieNode cur = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = cur.children.get(ch);
			if (next == null)
				cur.children.put(ch, next = new TrieNode());
			cur = next;
		}
		cur.word = true;
	}
	
	public void printSorted() {
		printSorted(root, "");
	}
	
	private void printSorted(TrieNode node, String s) {
		if (node.word) {
			System.out.println(s);
		}
		for (Character ch : node.children.keySet()) {
			printSorted(node.children.get(ch), s + ch);
		}
	}
	
//	public static void main(String[] args) {
//		DictPrefixTree tree = new DictPrefixTree();
//		tree.printSorted();
//	}

}
