import java.util.Scanner;

class Calculator {
  // Your code here

  public static int add(int n1, int n2){
  	return (n1 + n2);
  }


  public static int subtract(int n1, int n2){
  	return (n1 - n2);
  }

  public static int multiple(int n1, int n2){
  	return (n1 * n2);
  }



  public static double add(double n1, double n2){
  	return (n1 + n2);
  }


  public static double subtract(double n1, double n2){
  	return (n1 - n2);
  }

  public static double multiple(double n1, double n2){
  	return (n1 * n2);
  }

}

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int in1, in2;
		double dn1, dn2;

		in1 = keyboard.nextInt();
		in2 = keyboard.nextInt();

		System.out.println(in1 + " + " + in2 + " = " + Calculator.add(in1, in2));
		System.out.println(in1 + " - " + in2 + " = " + Calculator.subtract(in1, in2));
		System.out.println(in1 + " * " + in2 + " = " + Calculator.multiple(in1, in2));

		dn1 = keyboard.nextDouble();
		dn2 = keyboard.nextDouble();

		System.out.println(dn1 + " + " + dn2 + " = " + Calculator.add(dn1, dn2));
		System.out.println(dn1 + " - " + dn2 + " = " + Calculator.subtract(dn1, dn2));
		System.out.println(dn1 + " * " + dn2 + " = " + Calculator.multiple(dn1, dn2));

		keyboard.close();
	}
}
