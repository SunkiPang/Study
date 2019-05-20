import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
		LinkedList<String> list = new LinkedList<String>();
		// Your code here
		while(true){
			String input = keyboard.next();
			if(input.equalsIgnoreCase ("quit")){
				break;
			}
			list.addFirst(input);
		}

		Iterator<String> itr = list.iterator();
		// Your code here
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		keyboard.close();
  }
}
