import java.util.Random;
import java.util.Scanner;

public class GuessingNumber {

   public static void main(String[] args) {

       Scanner keyboard = new Scanner(System.in);
       System.out.print("Enter your name: ");
       String userName = keyboard.nextLine();
       System.out.println("Welcome, " + userName + "! to the guessing game. You will be given 4 chances to guess the number.");

       while (true) {

           int randomNumber = new Random().nextInt(100) + 1;
           int userGuess = 0;
           System.out.println("A number has been choosen.");
           //System.out.println(randomNumber);
           for (int chance = 1; chance <= 4; chance++) {
               System.out.print("Enter your guess: ");
               userGuess = keyboard.nextInt();
               if (userGuess == randomNumber) {
                   System.out.println("Congratulations. You guessed it with " + chance + " tries.");
                   break;
               } else if (userGuess > randomNumber) {
                   System.out.println("Lower!");
               } else {
                   System.out.println("Higher!");
               }
               if (chance == 4) {
                   System.out.println("Sorry! You lost all your chances");
                   System.out.println("The secret number was : " + randomNumber);
               }
           }
       }
   }
}
