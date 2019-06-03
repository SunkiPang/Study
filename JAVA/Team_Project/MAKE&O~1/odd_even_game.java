import java.util.Random;
import java.util.Scanner;

public class odd_even_game {
	private int C_number;
	private int P_number;
	private int count=0;
	private boolean win=false;
	
	public void play() {
		set_game();
		explain();
		while(!win) {
			input();
			isWin();
		}
		
	}
	public void explain() {
		System.out.println("이것은 ODD_EVEN_GAME입니다.");
		System.out.println("컴퓨터의 숫자가 홀수 일 것같으면 1 짝수 일것같으면 0을 입력하세요.");
		System.out.println("기회 3번 이내에 숫자를 맞추면 다음 단계로 넘어 갈 수 있습니다.");
	}
	public boolean isClear() {
		if(count>=3) {
			count=0;
			System.out.println("게임을 클리어하지 못했습니다. 처음부터 다시 시작합니다.");
			return false;
		}
		else {
			System.out.println("게임을 클리어 했습니다.");
			System.out.println("다음 게임을 준비 하십시오.");
			return true;
		}
	}
	public void isWin() {
		if(C_number==P_number) {
			
			System.out.println("당신은 "+ count+ " 번 만에 게임을 이겼습니다!");
			if(isClear()) {
			win= true;	
			}
		}
		else  {
			win=false;
			System.out.println("당신은 게임을 패배 했습니다.");
			System.out.println("게임을 초기화 중입니다.");
			if (count>=3) isClear(); 
			set_game();
		}
	}
	public void set_game() {
		count++;
		Random random= new Random();
		C_number=random.nextInt(2);
	}
	public void input() {
		Scanner keyboard = new Scanner(System.in);
		P_number=keyboard.nextInt();
		
	}
}
