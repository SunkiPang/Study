import java.util.Random;
import java.util.Scanner;


class Baseball {
	private int[] com = new int[3]; //랜덤 값이 들어갈 배열
	private int[] user = new int[3]; //사용자의 답변이 들어갈 배열
	private int strike; //스트라이크
	private int ball; //볼

	public Baseball() {

		Scanner kb = new Scanner(System.in);

		set_random();
		print_com_num();
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

	private void print_com_num(){
			System.out.println("{ " + com[0] + " " + com[1] + " " + com[2] + " }");
	}

}



class Main {
  public static void main(String[] args) {
    Baseball b = new Baseball();

  }
}
