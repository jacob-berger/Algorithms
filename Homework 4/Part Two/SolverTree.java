import java.util.Arrays;

public class SolverTree
{

	private class Node
	{
		char c;
		Node c1, c2, c3, c4;

		private Node(char c)
		{
			this.c = c;
		}

		private Node()
		{

		}

	}

	Node root;
	DictHashTable table = new DictHashTable();

	public SolverTree()
	{
		this.root = new Node();
	}

		public void buildSolver(int digits[], Node curr)
		{
			if(digits == null || digits.length == 0 || curr == null)
				return;

			char[] letters;

				letters = getLetters(digits[0]);
				curr.c1 = new Node(letters[0]);

				letters = getLetters(digits[0]);
				curr.c2 = new Node(letters[1]);

				letters = getLetters(digits[0]);
				curr.c3 = new Node(letters[2]);

				if(digits[0] == 7 || digits[0] == 9)
				{
					letters = getLetters(digits[0]);
					curr.c4 = new Node(letters[3]);
				}

				buildSolver(Arrays.copyOfRange(digits, 1, digits.length), curr.c1);
				buildSolver(Arrays.copyOfRange(digits, 1, digits.length), curr.c2);
				buildSolver(Arrays.copyOfRange(digits, 1, digits.length), curr.c3);
				buildSolver(Arrays.copyOfRange(digits, 1, digits.length), curr.c4);
		}

		public char[] getLetters(int n)
		{
			if(n == 1 || n == 0)
				return null;

			char[] arra = new char[4];

			if(n == 2)
			{
				arra[0] = 'a';
				arra[1] = 'b';
				arra[2] = 'c';
			}
			else if(n == 3)
			{
				arra[0] = 'd';
				arra[1] = 'e';
				arra[2] = 'f';
			}
			else if(n == 4)
			{
				arra[0] = 'g';
				arra[1] = 'h';
				arra[2] = 'i';
			}
			else if(n == 5)
			{
				arra[0] = 'j';
				arra[1] = 'k';
				arra[2] = 'l';
			}
			else if(n == 6)
			{
				arra[0] = 'm';
				arra[1] = 'n';
				arra[2] = 'o';
			}
			else if(n == 7)
			{
				arra[0] = 'p';
				arra[1] = 'q';
				arra[2] = 'r';
				arra[3] = 's';
			}
			else if(n == 8)
			{
				arra[0] = 't';
				arra[1] = 'u';
				arra[2] = 'v';
			}
			else if(n == 9)
			{
				arra[0] = 'w';
				arra[1] = 'x';
				arra[2] = 'y';
				arra[3] = 'z';
			}
			else
				return null;

			return arra;
		}

		public void buildWords(int in)
		{
			String path = "";
			buildWordsFromPath(root, path, in);
		}

		public void buildWordsFromPath(Node root, String s, int in)
		{

			if(root == null)
				return;

			s = s + root.c;

			if(root.c1 == null && root.c2 == null && root.c3 == null && root.c4 == null)
			{
				String word = s.substring(1);

				if(in == 1)
				{
					if(table.isWord(word))
						System.out.println(word);


				}

				if(in == 2)
				{
					if(DictPrefixTree.isWords(word))
						System.out.println(word);
				}
				return;
			}

			else
			{
				buildWordsFromPath(root.c1, s, in);
				buildWordsFromPath(root.c2, s, in);
				buildWordsFromPath(root.c3, s, in);
				buildWordsFromPath(root.c4, s, in);
			}

		}

}

