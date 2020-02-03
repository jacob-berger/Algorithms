import java.util.Scanner;

public class Tester
{
	public static void main(String[] args)
	{
		SolverTree tree;
		int[] d = new int[0];
		
//		tree.buildSolver(d, tree.root);
//
//		boolean exit = false;
//
//		while(!exit)
//		{
//			System.out.println("\nWhat would you like to do?\n" +
//					"1: Test against a Hashtable\n" +
//					"2: Test against a Prefix Tree\n" +
//					"0: Exit\n");
//			int choice = kb.nextInt();
//
//			if(choice == 1)
//			{
//				System.out.println("Testing Hashtable implementation...\n");
//				tree.buildWords(1);
//			}
//			if(choice == 2)
//			{
//				System.out.println("Testing Prefix Tree implementation...\n");
//				tree.buildWords(2);
//			}
//			if(choice == 0)
//				exit = true;
//			kb.close();
//		}
		
		do {
			d = userInput();
			if (d.length != 0) {
				tree = new SolverTree();
				tree.buildSolver(d, tree.root);
				System.out.println("Testing against Hashtable...\n");
				tree.buildWords(1);
				System.out.println();
				System.out.println("Testing against Prefix Tree...\n");
				tree.buildWords(2);
				System.out.println();
			}
		} while (d.length != 0);
	}

	public static int[] userInput()
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter in keypad numbers or type 'exit'\n" +
				"(Example: 23456)\n" +
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
		if (n.compareToIgnoreCase("exit") == 0) {
			return new int[0];
		}
		int[] arra = new int[n.length()];
		for (int ix = 0; ix < n.length(); ix++) {
			try {
				arra[ix] = Integer.parseInt(n.substring(ix, ix + 1));
				if (arra[ix] == 0 || arra[ix] == 1) {
					throw new IllegalArgumentException();
				}
			} catch (Exception e) {
				e.getMessage();
				System.out.println("Numbers entered must be 2-9 and cannot be letters or special characters\n");
				return userInput();
			}
		}
		
//		int[] d = new int[arra.length];
//
//
//
//		for(int i = 0; i < arra.length; i++)
//		{
//			if(arra[i] != 0 && arra[i] != 1)
//			{
//
//				try {
//					d[i] = Integer.parseInt(arra[i]);
//				} catch (Exception e) {
//					System.out.println("Numbers entered in must be between 2-9 and cannot be letters or special characters\n" +
//							"Please try again...\n");
//					userInput();
//				}
//			}
//			else
//			{
//				System.out.println("Numbers entered in must be between 2-9 and cannot be letters or special characters\n" +
//						"Please try again...\n");
//				userInput();
//			}
//
//		}
//
		return arra;
	}
}
