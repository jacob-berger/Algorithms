import java.util.Scanner;

public class Tester
{
	public static void main(String[] args)
	{
		SolverTree tree = new SolverTree();
		DictPrefixTree pfTree = new DictPrefixTree();
		DictHashTable hashTable = new DictHashTable();
		Scanner kb = new Scanner(System.in);


		int[] d = userInput();
		tree.buildSolver(d, tree.root);

		boolean exit = false;

		while(!exit)
		{
			System.out.println("\nWhat would you like to do?\n" +
					"1: Test against a Hashtable\n" +
					"2: Test against a Prefix Tree\n" +
					"0: Exit\n");
			int choice = kb.nextInt();

			if(choice == 1)
			{
				System.out.println("Testing Hashtable implementation...\n");
				tree.buildWords(1);
			}
			if(choice == 2)
			{
				System.out.println("Testing Prefix Tree implementation...\n");
				tree.buildWords(2);
			}
			if(choice == 0)
				exit = true;
		}

	}

	public static int[] userInput()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter in keypad numbers with a comma separating each number & no spaces\n" +
				"(Example: 2,3,4,5,6)\n" +
				"KeyPad: \n" +
				"2 = (a b c)\n" +
				"3 = (d e f)\n" +
				"4 = (g h i)\n" +
				"5 = (j k l)\n" +
				"6 = (m n o)\n" +
				"7 = (p q r s)\n" +
				"8 = (t u v)\n" +
				"9 = (w x y z)\n" +
				"---> ");
		String n = kb.nextLine();
		String[] arra = n.split(",");
		int[] d = new int[arra.length];



		for(int i = 0; i < d.length; i++)
		{
			if(arra[i].equals("2") || arra[i].equals("3") || arra[i].equals("4") || arra[i].equals("5") ||
					arra[i].equals("6") || arra[i].equals("7") || arra[i].equals("8") || arra[i].equals("9"))
			{

				d[i] = Integer.parseInt(arra[i]);
			}
			else
			{
				System.out.println("Numbers entered in must be between 2-9 and cannot be letters or special characters\n" +
						"Please try again...\n");
				userInput();
			}

		}

		return d;
	}
}
