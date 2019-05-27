import java.util.Scanner;

class Calculator {
  // Your code here
  public static double average(int n[]){
  	int sum = 0;
  	double average = 0;
  	for (int i = 0; i < n.length; i++){
  		sum = sum + n[i];
  	}
  	average = (double)sum/n.length;
  	return average;
  }

}

class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
		int n = 0;
		n = keyboard.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = keyboard.nextInt();

		System.out.print("Average of ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println("is " + Calculator.average(arr));
		keyboard.close();
  }
}
