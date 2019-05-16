import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
		ArrayList<String> toDoList = new ArrayList<String>();
		boolean done = false;
		while (true) {
			System.out.println ("Type an entry:");
			String entry = keyboard.nextLine ();
			if (entry.equalsIgnoreCase ("quit"))
				break;
			toDoList.add (entry);
			//String ans = keyboard.nextLine ();

		}
		System.out.println ("The list contains:");
		int listSize = toDoList.size ();
		for (int position = 0 ; position < listSize ; position++)
		System.out.println (toDoList.get (position));

		keyboard.close();
  }
}
