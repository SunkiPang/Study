import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

class Main {
  public static void main(String[] args) {
		String filename = "out.txt";
		Scanner inputStream = null;
		// Don't change this
		// prepare() is setting which makes test file
		prepare(filename);


		// Your code here
		try{
			inputStream = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			System.out.println("Error opning the file" + filename);
			System.exit(0);
		}
		while (inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			System.out.println(line);
		}

		inputStream.close();
	}

	public static void prepare(String filename) {
		PrintWriter outputStream = null;
		Random generator = new Random(10);

		try {
			outputStream = new PrintWriter(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}

		for (int i = 0; i < 3; i++) {
			int length = generator.nextInt(10) + 1;
			for (int count = 0; count < length; count++)
				outputStream.print((char)(generator.nextInt(26) + 65));
			outputStream.println();
		}

		outputStream.close();
	}

}
