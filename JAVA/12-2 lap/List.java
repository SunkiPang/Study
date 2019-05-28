import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}
  
	public String toString() {
		return name;
	}
}

class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

		// Your code here
		int n = keyboard.nextInt();
		LinkedList<Person> list = new LinkedList<>();

		for(int i = 0; i < n+1; i++){
			String name = keyboard.nextLine();
			Person p1 = new Person(name);
			list.add(p1);
		}

		Iterator<Person> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		keyboard.close();
  }
}
