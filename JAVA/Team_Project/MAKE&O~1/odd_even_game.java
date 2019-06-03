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
		System.out.println("�̰��� ODD_EVEN_GAME�Դϴ�.");
		System.out.println("��ǻ���� ���ڰ� Ȧ�� �� �Ͱ����� 1 ¦�� �ϰͰ����� 0�� �Է��ϼ���.");
		System.out.println("��ȸ 3�� �̳��� ���ڸ� ���߸� ���� �ܰ�� �Ѿ� �� �� �ֽ��ϴ�.");
	}
	public boolean isClear() {
		if(count>=3) {
			count=0;
			System.out.println("������ Ŭ�������� ���߽��ϴ�. ó������ �ٽ� �����մϴ�.");
			return false;
		}
		else {
			System.out.println("������ Ŭ���� �߽��ϴ�.");
			System.out.println("���� ������ �غ� �Ͻʽÿ�.");
			return true;
		}
	}
	public void isWin() {
		if(C_number==P_number) {
			
			System.out.println("����� "+ count+ " �� ���� ������ �̰���ϴ�!");
			if(isClear()) {
			win= true;	
			}
		}
		else  {
			win=false;
			System.out.println("����� ������ �й� �߽��ϴ�.");
			System.out.println("������ �ʱ�ȭ ���Դϴ�.");
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
