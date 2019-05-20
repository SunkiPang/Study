import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
		String in_filename = "in.csv";
		String out_filename = "out.csv";
		prepare(in_filename);

		Scanner inputStream = null;
		PrintWriter outputStream = null;

		// Your code here
		try{
			outputStream = new PrintWriter(out_filename);
		}
		catch(FileNotFoundException e){
			System.out.println("Error");
			System.exit(0);
		}
		try {
			inputStream = new Scanner(new File(in_filename));
		}
		catch(FileNotFoundException e){
			System.out.println("Error");
			System.exit(0);
		}
		int[] num = new int[3];
		while(inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			String[] arr = line.split(",");
			int sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);

			outputStream.println(line + "," +sum);
		}



		outputStream.close();
		inputStream.close();

		check(out_filename);
	}

	public static void prepare(String filename) {
		PrintWriter outputStream = null;
		Random generator = new Random(15);

		try {
			outputStream = new PrintWriter(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}

		for (int count = 0; count < 5; count++)
			outputStream.println(generator.nextInt(30) + "," + generator.nextInt(20));

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
