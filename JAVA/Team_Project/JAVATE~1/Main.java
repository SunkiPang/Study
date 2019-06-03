import java.util.Random;
import java.util.Scanner;
//file io(to draw thanos)
import java.io.File;
import java.io.FileNotFoundException;




class Main {
	
  static Scanner keyboard = new Scanner(System.in);
  public static void main(String[] args) {
    


	String name;
  	int m;
	
	MakeID id = new MakeID();
	id.play();
	name = id.get_name();
	
	System.out.println("");
	System.out.println("Your name is " + name);
	System.out.println("");

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
		m = menu.showMenu();
    	if(m == -1) m = menu.showMenu();
    	else if(m == 1) od.play();
    	else if(m == 2) gn.play();
    	else if(m == 3) rsp.play();
		else if(m == 4)	ttt.play();
		else if(m == 5) break;
	}

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


	base.play();

	
	//gn.play();
	//rsp.play();
	//base.play();
	//ttt.play();
  	
  }
}
