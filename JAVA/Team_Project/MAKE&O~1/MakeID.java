import java.util.Random;
import java.util.Scanner;

public class MakeID {
	private String name;
	private String start;
	private String[] hero= {"Iron Man","Captain America","Thor","Hulk","Black widow","Hawkeye","Dr.Strange","Spider Man","Falcon","Ant Man","Vision","Scarlet Witch","War Machine","Mantis","Star-Lord","Gamora","Drax","Rocket Raccon","Groot","Black Panther"};
	public void play() {
		check_Start();
		set_name();
		
	}
	public void check_Start() {
		Scanner keyboard= new Scanner(System.in);
		System.out.println("게임을 시작하시겠 습니까?[Y/N]");
		start= keyboard.nextLine();
		if(start.equals("N")) System.exit(0);
	}
	public void set_name() {
		Random random= new Random();
		name= hero[random.nextInt(20)];
	}
	public String get_name() {
	return name;	
	}
}
