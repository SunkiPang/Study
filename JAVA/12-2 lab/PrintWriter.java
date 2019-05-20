import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
		String filename = "out.txt";
		PrintWriter outputStream = null;
		Scanner keyboard = null;

		System.out.println("Enter three lines of text: ");
		// Your code here
		try{
			outputStream = new PrintWriter(filename);
		}
		catch(FileNotFoundException e){
			System.out.println("Error opning the file" + filename);
		}
		keyboard = new Scanner(System.in);

		for(int count = 1; count <= 3; count++){
			String line = keyboard.nextLine();
			outputStream.println(count + " " + line);
		}



		outputStream.close();
		keyboard.close();

		// Don't change this
		// This method read and prints from file for scoring
		check(filename);
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
