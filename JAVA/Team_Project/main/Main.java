import java.util.Random;
import java.util.Scanner;
//file io(to draw thanos)
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


 

class Main {

  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {

   String name;
     int m;
   String record_name[] = new String[3];
   long record_time[] = new long[3];
   long max_time = 999999;

  for(int i = 0; i < 3 ; i++){
      record_name[i] = null;
      record_time[i] = max_time;
   }

      String file_rank = "rank.txt";
      int record_count = 0;
      Scanner io  = null;
      try{
         io = new Scanner(new File(file_rank));
      }
      catch(FileNotFoundException e){
         System.out.println("Error opening file: " + file_rank);
         System.exit(0);
      }
      while(io.hasNextLine()){
         String line = io.nextLine();
         record_name[record_count] = line;
         line = io.nextLine();
         record_time[record_count] = Long.parseLong(line);
         record_count++;
      }


   show_ranking(record_name, record_time);

   MakeID id = new MakeID();
   id.play();
   name = id.get_name();

   long start_time = System.currentTimeMillis();


   System.out.println("\nYour name is " + name);
   System.out.println("Nick Fury : Here is a space stone, you need 5 stones to meet thanos. good luck! \n");




   ShowingMenu menu = new ShowingMenu(name);
   RockScissorPaper rsp = new RockScissorPaper(name);
   Baseball base = new Baseball(name);
   GuessingNumber gn = new GuessingNumber(name);
   Odd_Even od = new Odd_Even(name);
   TTT ttt = new TTT(name);

   while(true){
      menu.checkClear(rsp);
      menu.checkClear(gn);
      menu.checkClear(od);
    menu.checkClear(ttt);

      m = menu.showMenu();
       if(m == -1) m = menu.showMenu();
       else if(m == 1) od.play();
       else if(m == 2) gn.play();
       else if(m == 3) rsp.play();
        else if(m == 4)   ttt.play();
      else if(m == 5) break;
   }

   System.out.println("\n\nNick Fury: Since you got this far.. you deserve the last stone");
   System.out.println("\nNick Fury : Here is a soul stone");
   System.out.println("Nick Fury : You are now in a final stage, here is a power stone ");
   System.out.println("Nick Fury : You made it! Good luck with thanos!");


    String fn = "Thanos0.txt";
    String fn1 = "Game0.txt";

    Scanner inS = null;
    Scanner inS2 = null;

    try{
      inS = new Scanner(new File(fn));
      inS2 = new Scanner(new File(fn1));
      }
    catch(FileNotFoundException e){
      System.out.println("Error opening file");
      System.exit(0);
    }
    while(inS.hasNextLine()){
      String line = inS.nextLine();
      System.out.println(line);
    }
    while(inS2.hasNextLine()){
      String line = inS2.nextLine();
      System.out.println(line);
    }

    inS.close();
    inS2.close();


  System.out.println("Are you ready to fight with Thanos?[Y/N]");
      String s= keyboard.nextLine();
      if(s.equalsIgnoreCase("N")){
         System.out.println("\nThanos : haha. you're a coward. ");
         System.out.println("         I will make you disappearfinger snap...");
         System.out.println("         Now you lose the game. ");


         //System.out.println("         Game Over ");

         System.exit(0);
      }

        System.out.println("\nThanos : well, well, well look who's here ... ");
      System.out.println("         Are you ready to accept your fate? ");

      System.out.println("\nDr.Strange : we are in the endgame now. ");
      System.out.println("Captain America : Avengers!..... Assemble \n");

   base.play();


   //time check

   long end_time = System.currentTimeMillis();
   long play_time = (end_time - start_time)/(long)1000.0;
   int arr_count = 0;
   for(arr_count = 0 ; arr_count < 3; arr_count++){
      if(play_time <= record_time[arr_count]){
         break;
      }
   }

   if(record_time[arr_count] == max_time){
      record_time[arr_count] = play_time;
      record_name[arr_count] = name;
   }

   else if(arr_count == 0){
    push_rank(record_name, record_time, 2, 1);
    push_rank(record_name, record_time, 1, 0);
      record_time[arr_count] = play_time;
      record_name[arr_count] = name;

   }else if(arr_count == 1){
    push_rank(record_name, record_time, 2, 1);
      record_time[arr_count] = play_time;
      record_name[arr_count] = name;
   }else if(arr_count == 2){
      record_time[arr_count] = play_time;
      record_name[arr_count] = name;
   }


   System.out.println("\nclear time : " + (end_time - start_time)/1000.0 + " sec");


    try {
      FileWriter fw = new FileWriter(file_rank);
      for(int j = 0; j < 3; j++){
        fw.write(record_name[j] + "\n");
        fw.write((int)record_time[j] + "\n");
     }
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
   }

  show_ranking(record_name, record_time);




  }

   static void show_ranking(String[] record_name, long[] record_time){
      System.out.println(" \n");
       System.out.println("       *     RANKING      *       ");
         System.out.println("____________________________________\n");
      for(int i = 0; i < 3; i++){
         System.out.println("\t"+(i+1) + ". " + record_name[i] + " : " + record_time[i] + " (sec)");
      }
      System.out.println("____________________________________\n");

  }

  static void push_rank(String[] record_name, long[] record_time, int i1, int i2){
    record_time[i1] = record_time[i2];
      record_name[i1] = record_name[i2];
  }
}
