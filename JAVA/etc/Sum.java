import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

class Main {
  public static void main(String[] args) {
		String filename = "out.bat";
		prepare(filename);

		ObjectInputStream inputStream = null;
		// Your code here
		int sum = 0;
		try{
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			int i;

			for(i = 0; i < 100; i++)
				sum += inputStream.readInt();


			System.out.println(sum);
			inputStream.close();
		}
		catch(FileNotFoundException e){
			System.out.println(sum);
		}
		catch(IOException e){
			System.out.println(sum);
		}

	}

	public static void prepare(String filename) {
		ObjectOutputStream outputStream = null;
		Random generator = new Random(30);

		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(filename));
			for (int i = 0; i < generator.nextInt(20) + 4; i++)
				outputStream.writeInt(generator.nextInt(50000) - 25000);
			outputStream.writeInt(0);
			outputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + filename);
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Error while I/O to " + filename);
			System.exit(0);
		}
	}

}
