import java.util.Scanner;

class Product {
  	// Your code here

	  	private static int count = 0;

		public int getSerialNumber(){
			return ++count;
		}
}

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Product p;
		int num = keyboard.nextInt();

		for (int i = 0; i < num; i++) {
			p = new Product();
			System.out.println("Serial number: " +
					 p.getSerialNumber());
		}

		keyboard.close();
	}
}
