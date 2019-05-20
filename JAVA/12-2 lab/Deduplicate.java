import java.util.Scanner;
import java.util.HashSet;

class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    HashSet<Integer> intSet = new HashSet<Integer>();
	int n = keyboard.nextInt();
		// Your code here
	for(int i = 0; i < n; i++){
		int k = keyboard.nextInt();
		intSet.add(k);
	}
	printSet(intSet);

	keyboard.close();
  }

public static void printSet(HashSet<Integer> intSet){
		for (Object obj : intSet.toArray()){
			Integer num = (Integer) obj; System.out.println(num.intValue());
		}
	}
}
