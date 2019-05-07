import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
		String filename = "out.txt";
		PrintWriter outputStream = null;
		Scanner inputStream = null;
		prepare(filename);

		// Your code here
		/*

*/
		try{
			outputStream = new PrintWriter(new FileOutputStream(filename,true));
		}
		catch(FileNotFoundException e){
			System.out.println("Error");
			System.exit(0);
		}
		try {
			inputStream = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			System.out.println("Error");
			System.exit(0);
		}
		while(inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			outputStream.println(line);
		}






		inputStream.close();
		outputStream.close();

		check(filename);
	}

	public static void prepare(String filename) {
		PrintWriter outputStream = null;
		Random generator = new Random(12);

		try {
			outputStream = new PrintWriter(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}

		for (int count = 0; count < 10; count++)
			outputStream.print((char)(generator.nextInt(26) + 65));

		outputStream.close();
	}

	public static void check(String filename) {
		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}

		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			System.out.println(line);
		}
		inputStream.close();
	}
}
