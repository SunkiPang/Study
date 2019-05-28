import java.util.Random;
import java.util.Scanner;


class Baseball {
	private String name;
	private int[] com = new int[3]; //랜덤 값이 들어갈 배열
	private int[] user = new int[3]; //사용자의 답변이 들어갈 배열
	private int strike; //스트라이크
	private int ball; //볼
	private int is_clear = 0;

	public Baseball(String init_name) {


		name = init_name;

	}

	private void set_random(){
		Random rand = new Random();
		int count = 0;
		boolean[] already = new boolean[10]; //랜덤 숫자가 중복인지 확인하기 위해 필요한 boolean 배열

		for(int i = 0; i < 10 ; i++) {
			already[i] = false; //false로 초기화
		}

		for (int i = 0; i < 10; i++)
		while(count < 3) {
			int rand_num = rand.nextInt(10);
			if(!already[rand_num]) {
				com[count] = rand_num;
				already[rand_num] = true;
				count++;
			}
		}
	}

	private void set_user_num(){

		Scanner kb = new Scanner(System.in);
		int count = 0;
		while(count != 3){
			System.out.println("Input your " + (count+1) + " number ");
			int temp = kb.nextInt();
			int flag = 0;
			for(int i = 0; i < count; i++){
				if(user[i] == temp){
					flag = 1;
					break;
				}
			}
			if(flag == 1){
				System.out.println("Duplicate!!");
				flag = 0;
			}
			else{
				user[count] = temp;
				count++;
			}
		}
	}

	//이제 해야 할 것.
	//숫자 비교하기

	public void play(){
		set_random();
		print_com_num();
		set_user_num();
		print_user_num();
	}

	public boolean clear(){

		return false;
	}


	private void print_com_num(){
			System.out.println("{ " + com[0] + " " + com[1] + " " + com[2] + " }");
	}

	private void print_user_num(){
			System.out.println("{ " + user[0] + " " + user[1] + " " + user[2] + " }");
	}

}



class Main {
  public static void main(String[] args) {
    Baseball b = new Baseball("Stark");
	b.play();
  }
}
