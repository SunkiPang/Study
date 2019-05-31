import java.util.Scanner;

public class ShowingMenu{
  private String name;
  private boolean[] clear = new boolean[4];
  //boolean[] clear = new boolean[]{false, true, false, false};

  public ShowingMenu(String n){
    name = n;
  }
  
  public void checkClear(Object o){
    //아직 class 이름을 정확하게 몰라서 임의로 넣음

    //<role of checkClear method>
    //main에서 method call하면
    //object로 각 게임을 받아서
    //clear method로 clear 여부 확인
    //결과를 array에 저장

    if(o instanceof Odd_Even){
      Odd_Even game = (Odd_Even)o;
      if(game.clear()) clear[0] = true;
      clear = false;
    }

    if(o instanceof GuessingNumber){
      GuessingNumber game = (GuessingNumber)o;
      if(game.clear()) clear[1] = true;
      clear = false;
    }

    if(o instanceof RockScissorPaper){
      RockScissorPaper game = (RockScissorPaper)o;
      if(game.clear()) clear[2] = true;
      clear = false;
    }

    if(o instanceof TicTacToe){
      TicTacToe game = (TicTacToe)o;
      if(game.clear()) clear[3] = true;
      clear = false;
    }
  }

  public int showMenu(){
    //<role of showMenu method>
    //show username + list of menu
    //show clear if the game cleared
    //return the user's input
    //return 5 if all games cleard
    //recive this return value in main and play the game
    
    Scanner kb = new Scanner(System.in);

    System.out.println("\n\n\"Hello " + name + "! \nYou have to clear four games to fight with Thanos.\"\n");

    System.out.println("************************************************");
    System.out.println("*                  GAME LIST                   *");
    System.out.println("************************************************");

    System.out.print(" 1. Odd Even game.");
    if(clear[0]) System.out.print("\t\t\t\t\t\t [ClEAR]");
    else System.out.print("\t\t\t\t\t [NOT CLEAR]");

    System.out.print("\n 2. Guessing Number game.");
    if(clear[1]) System.out.print("\t\t\t\t [ClEAR]");
    else System.out.print("\t\t\t [NOT CLEAR]");

    System.out.print("\n 3. Rock Scissors Paper game. ");
    if(clear[2]) System.out.print("\t\t\t [ClEAR]");
    else System.out.print("\t\t [NOT CLEAR]");

    System.out.print("\n 4. Tic Tac Toe game. ");
    if(clear[3]) System.out.print("\t\t\t\t\t [CLEAR]");
    else System.out.print("\t\t\t\t [NOT CLEAR]");

    System.out.println("\n************************************************");
    System.out.println("\"Please choose game to play!\"");
    System.out.print("your input(only number)>>> ");
    int menu = kb.nextInt();

    kb.close();

    if(clear[menu-1]){
      System.out.println("\"It was already clear.\"");
      return -1;
    }//if input value game was clear -> return -1
    else if(menu < 1 && menu > 4){
      System.out.println("\"There is no game " + menu + " in the game list.\"");
      return -1;
    }//if input value game was worng -> return -1
    else System.out.println("\"Good luck "+ name + ". \nPlease save the world!!!\"");

    if(clear[0]&&clear[1]&&clear[2]&&clear[3]) return 5;

    return menu; // defalut
  }

}