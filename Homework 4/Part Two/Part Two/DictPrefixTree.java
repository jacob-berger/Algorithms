import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DictPrefixTree
{

	private static class TrieNode
	{
		boolean word = false;
		Map<Character, TrieNode> children = new TreeMap<>();
	}

	private static TrieNode root;

	public DictPrefixTree()
	{
		root = new TrieNode();
		File fin = new File("dictionary.txt");
		readWords(fin);
	}

	static DictPrefixTree tree = new DictPrefixTree();


	public void readWords(File file)
	{
		try {
			Scanner fin = new Scanner(file);
			while (fin.hasNext()) {
				String string = fin.nextLine().split(",")[0];
				insertString(string);
			}
			fin.close();
		}
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
	}

	public void insertString(String s)
	{
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


	public static boolean isWords(String s)
	{
		return isWords(root, s);
	}

	public static boolean isWords(TrieNode r, String s)
	{
		if(s != null && s.length() > 0)
		{
			String rest = s.substring(1);
			char ch = s.charAt(0);
			TrieNode child = r.children.get(ch);

			if(s.length() == 1 && child != null){
				if(child.word){
					return true;
				}
			}
			if(child == null)
				return false;
			else
				return isWords(child, rest);
		}
		return false;

	}

}
