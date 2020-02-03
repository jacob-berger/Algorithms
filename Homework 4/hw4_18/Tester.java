
public class Tester {

	public static void main(String[] args) {
		Trie2 myTrie = new Trie2();
		String string = "apple bike bake pen did ape child cat file hello he hell";
		String[] stringArray = string.split(" ");
		for (String item : stringArray) {
			myTrie.insertString(item);
		}
		
		System.out.println(myTrie.wordsPrefixedBy("ap"));
		System.out.println(myTrie.wordsPrefixedBy("he"));
	}
}
