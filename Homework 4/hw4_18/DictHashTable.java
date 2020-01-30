import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class DictHashTable {
	
	Hashtable<Integer, String> table;

	public DictHashTable() {
		table = new Hashtable<Integer, String>();
		
		try {
			File file = new File("dictionary.txt");			
			readWords(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void readWords(File file) {
		
		try {
			Scanner fin = new Scanner(file);
			int ix = 0;
			
			while (fin.hasNext()) {
				String string = fin.nextLine().split(",")[0];
				table.put(ix, string);
				ix++;
			}
			fin.close();
//			System.out.println("Dictionary hashtable created.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	public static void main(String[] args) {
//		DictHashTable table = new DictHashTable();
//		
//	}
	
}
