import java.util.Scanner;

class Account {
  private String owner;
  private int balance;

	public Account(String init_name, int init_money){
		owner = init_name;
		balance = init_money;
	}

	public void printStatus(){
		System.out.println(owner + "'s Account.");
		System.out.println("balance : " + balance);
	}
  // Your code here
}

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name;
		int money;

		System.out.print("Input your name: ");
		name = keyboard.next();

		System.out.print("Input initial money: ");
		money = keyboard.nextInt();

		Account acc = new Account(name, money);
		acc.printStatus();

		keyboard.close();
	}
}
