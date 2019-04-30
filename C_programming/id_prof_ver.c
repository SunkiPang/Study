//오후 5시현재 코드

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
struct _myword{
	char eng[20];
	char kor[60];
};
struct _question{
	int ex[4];  // 지문으로 사용할 4개의 단어번호
	int answer;  // 정답번호 (1~4)
};
/*
코딩 4원칙
1. 생각후코딩
2. 조건과반복
3. 읽기와쓰기 - 변수, 배열, 포인터, 구조체, 구조체포인터, 파일
4. 주기와받기 - 주기는 파라미터, 받기는 리턴값
함수를 사용한다는 것은 주기와 받기를 서로 맞춰가는것..
*/
void makemyword(struct _myword* w[], int* c);
void printmyword(struct _myword* w[], int c);
void test(struct _myword* w[], int c, struct _question* e[], int* ec);
void testone(struct _myword* w[], int c, struct _question* e[], int* ec);
void makequestion(struct _myword* w[], int c, struct _question* q, int* qnum);
void printquestion(struct _myword* w[], struct _question* q);
void makerandom(int* n, int start, int stop, int amount);
void savetest(struct _myword* w[], int c, struct _question* e[], int ec);

int askmenu();
/*
	1) 단어장에서 4개의 중복되지 않는 단어를 선택한다. (랜덤사용)
	2) 이중에서 문제로 쓸 1개를 골라서 화면에 영어 단어를 출력한다.
	3) 남은 3개를 합하여 4개의 지문을 화면에 한글 뜻을 출력한다.
	4) 정답의 번호를 출력한다.
*/

int main(void) {
	struct _myword* myword[500];  // 단어장 (최대 500개)
	struct _question* myex[20]; // 문제집 (최대 20개)
	int wcount; // 단어장의 단어갯수
	int ecount; // 문제집의 문제갯수
	//count = makemyword(myword);
	srand(time(0));
	makemyword(myword, &wcount);
	//wcount=20;
	printf("made count : %d\n", wcount);
/*
	다음을 무한반복한다..
	- 메뉴를 보여준다.
	- 명령을 입력받는다.
	- 입력받은 명령이 무엇이냐에 따라서 다음 중 1개를 수행한다.
		1. 단어장 보기
		2. 시험 보기
		3. 채점 결과
		4. 시험문제지 저장
		0. 종료
*/
	int menuid;
	while(1){
		menuid = askmenu();  //정수로 메뉴번호를 받아온다.
		switch(menuid){
			case 0 : return 0;
			case 1 : printmyword(myword, wcount); break;
			case 2 : test(myword, wcount, myex, &ecount); break;
			case 3 : break;
			case 4 : savetest(myword, wcount, myex, ecount);
							break;
		}
	}
	return 0;
}
void test(struct _myword* w[], int c, struct _question* e[], int* ec){
	struct _question *q1; // 선언시에는 값이 의미가 없음..  메모리할당되어야 유의미함
	//printf("start - makequestion\n");
	/*
	- 일단 몇문제를 테스트 할 건지 물어보고..
	- 그만큼의 문제를 그냥 만들지 말고.. 일단 겹치지 않는 단어들을 미리 만들어놓고
	  무제 갯수만큼
	   ---> e[]에다가 채워 넣는다. --> 1문제를 채우는 일은 make_question()한테 시키자..
	- 그 문제를 화면에 출력하자. 갯수만큼 문제출력은 이미 완료..
	- 실제 테스트는 이따가...

	*/
	int howmany;
	printf("몇 문제?(최대 20) >> ");
	scanf("%d", &howmany);
// 뭔가 겹치지 않는 문제용 단어의 세트를 임시로 만들어 사용하면 좋겠다...
// 반드시 함수 종료 전에 메모리 반납을 시켜야 함.
	int* wset = malloc(sizeof(int)*howmany*4);
	int* answers = malloc(sizeof(int)*howmany); // 사용자 입력 답안
	int score=0; // 맞춘 문제
	makerandom(wset, 0, c-1, howmany*4);
	// 예 : howmany가 5이면.. 20개짜리 정수배열..
	// 0~3 : 1번문제용 단어
	// 4~7 : 2번문제용 단어
	// 8~11 : 3번문제용 단어..
	for(int i=0; i<howmany; i++){
		e[i] = (struct _question*)malloc(sizeof(struct _question));
		// 여기에서 메모리를 할당받아 주소를 확정지으면 유의미함
		makequestion(w, c, e[i], wset+(i*4)); // 얘한테 미리 만들어 둔 단어 4개의 번호를 주자..
	}
	*ec = howmany;

	//for(int i=0;i<4;i++) printf("%d\n",q1->ex[i]);
	//printf("start - printquestion\n");
	for(int i=0;i<howmany;i++){
		printf("%d. ", i+1);
		printquestion(w, e[i]);
		// 이 문제의 답을 입력받는다.
		printf("당신의 답은? ");
		scanf("%d", &answers[i]);
		// 일단 저장..
	}

	// 입력받은 답을 채점해서 그 결과를 알려준다..
	for(int i=0;i<howmany;i++){
		if(e[i]->answer == answers[i]) score++;
	}
	printf("당신의 점수는 %.1f점입니다.\n", 100.0*score/howmany);
	free(wset);  // 임시 메모리 반납
}

void testone(struct _myword* w[], int c, struct _question* e[], int* ec){
	struct _question *q1; // 선언시에는 값이 의미가 없음..  메모리할당되어야 유의미함
	//printf("start - makequestion\n");
	q1 = (struct _question*)malloc(sizeof(struct _question));
	// 여기에서 메모리를 할당받아 주소를 확정지으면 유의미함
	//makequestion(w, c, q1);
	for(int i=0;i<4;i++) printf("%d\n",q1->ex[i]);
	//printf("start - printquestion\n");
	printquestion(w, q1);
}

int askmenu(){
	int menu;
	printf("<menu> 1. print 2. test 3. score 4. save 0. exit >> ");
	scanf("%d", &menu);
	return menu;
}

void makemyword(struct _myword* w[], int* c){
	char str[80];
	FILE* f;  // 1. 파일핸들링변수를 선언
	f = fopen("input.txt","r");  // 2. 파일을 연다.
	if (f == NULL){
          printf("파일이 안열린덴다..\n");
          return;
     }
	//scanf("%s", str);
	//fscanf(f, "%s", str);  // 3. 파일을 다룬다. (읽는다)
	int count=0, tabindex, len;
	char eng[20];  // 임시용
	char kor[60];  // 임시용
	while(1){
		if (feof(f)||ferror(f)||!fgets(str, 80, f))
			break;
		tabindex = strchr(str, '\t')- str + 1;
		len = strlen(str);
		////////
		w[count] = (struct _myword *)malloc(sizeof(struct _myword)); // 구조체 하나를 메모리 할당
		////////
		strncpy(eng,str,tabindex-1);
		strncpy(kor,str+tabindex,len-tabindex);
		eng[tabindex-1]='\0';
		kor[len-tabindex-1]='\0';
		///////
		strcpy(w[count]->eng, eng);  // 구조체 멤버 내용 카피
		strcpy(w[count]->kor, kor);
		///////
		//kor[strlen(kor)-1]='\0'
		/*abced\t뜻이들어가다가\n
		tab = 6
		len = 21
		kor = 뜻이들어가다가\n
		kor의length = len */
		//printf("영문: [%s], 한글: [%s]\n", eng, kor);
		count++;
	}
	//printf("count : %d\n", count);
	fclose(f);  // 4. 파일을 닫는다.
	*c = count;
}

void printmyword(struct _myword* w[], int c){
	for(int i=0;i<c; i++){
		printf("%s - %s\n", w[i]->eng, w[i]->kor);
	}
	printf("\n");
}

void makequestion(struct _myword* w[], int c, struct _question* q, int* qnum){
/*
	1) 단어장(402)에서 4개의 중복되지 않는 단어를 선택한다. (랜덤사용)
	결국 만들어야 하는 것은 숫자 4개의 배열(0~401)
	예) {35,309,49,67}
	2) 이중에서 문제로 쓸 1개를 골라서 화면에 영어 단어를 출력한다.
	0~3중 하나를 랜덤으로 찾자. 이 번호의 숫자가 문제이며 정답
	예) 3번이라면.. 문제는 67번
	3) 남은 3개를 합하여 4개의 지문을 화면에 한글 뜻을 출력한다.
  위의 순서 그대로 출력하자.
	35 - 309 - 49 - 67
	정답의 번호는 어떻게 알수 있을까? 위에서 랜덤으로 찾아떤 정답번호는 3이니까 +1해서 4번이다.
	4) 정답의 번호를 출력한다.
	예) 그냥 4를 출력하면 됨
*/
	// q자체는 그냥 로컬 포인터 변수..
/*
struct _question{
	int ex[4];  // 지문으로 사용할 4개의 단어번호
	int answer;  // 정답번호 (1~4)
};
*/
	int qno; // 문제로 쓸 단어번호
	//makerandom(q->ex,0,401,4);  //지문으로 사용할 4개의 단어를 선택
	//for(int i=0;i<4;i++) printf("%d\n",q->ex[i]);
	for(int i=0; i<4; i++) q->ex[i] = qnum[i]; // 단순하게 받은 단어번호를 카피..
	q->answer = rand()%4 + 1;  //문제로 사용할 인덱스 (1~4)
	//return q;
}

void printquestion(struct _myword* w[], struct _question* q){

	//printf("start - 1\n");
	//for(int i=0;i<4;i++) printf("%d\n",q->ex[i]);
	int qno = q->ex[(q->answer)-1];  // 문제로 쓸 번호
	printf("다음 영어단어의 뜻을 찾으시오 : %s\n", w[qno]->eng);
	//printf("start - 2\n");
	for(int i=0;i<4;i++){  // 지문 출력
		printf("%2d) %s \n", i+1, w[q->ex[i]]->kor);
	}
	//printf("정답번호 : %d\n", q->answer);  //정답 출력

}

void makerandom(int* n, int start, int stop, int amount){
/*
뭐할건지? start부터 stop까지의 숫자 amount개를 랜덤하게 만들어서 n배열에 채운다.

반복하면서 랜덤수를 만들어 내야 하는데.. 도대체 몇번을 반복시켜야 하지? 모르겠다. 그러면 무한반복시키지 뭐.. 대충 만들다가 amount갯수만큼 채웠으면 break걸면 되겠지..

만들어진갯수 = 0
임의로만드는 랜덤수

다음을 무한반복하자..
  - 만들어진 갯수가 amount만큼되면 break;
  - 일단 랜덤수를 하나 만들자.
  - 얘를 배열에 넣을지 말지를 결정하자구..
  ----> 배열에 이미 들어있는 숫자들과 비교해서 중복안되면
  ----> 그때서야(중복안됨확인) 배열에 추가하고, 갯수로 인정..
  ----> 만일 중복된다면? 여기서 다시 랜덤수를 만든다? 노노
*/
	int count=0, r, dupped;
	while(1){
		if(count==amount) break;
		r = rand()%(stop-start+1)+start;
		dupped=0; // 중복이 안되었음으로 초기화
		for(int i=0; i<count; i++){
			if (r == n[i]) {
				dupped=1;  // 중복이 됨
				break;
			}
		}
		if(dupped==0){
			n[count] = r;
			count++;
		}
	}
}


void savetest(struct _myword* w[], int c, struct _question* e[], int ec){
/*
   해야할 일 : 문제지를 파일에 저장한다. 이때 파일이름은 test.txt로 하자..
	 저장하는 형식은 다음과 같이...
=================
	 영어단어시험
다음 각 문제에서 영어단어의 뜻을 고르시오..
1. 영어단어
1) 지문1 2) 지문2
3) 지문3 4) 지문4

2. 영어단어
1) 지문1 2) 지문2
3) 지문3 4) 지문4
.....
몇개가 되던지..

정답번호
1. 2) 2. 3) ....

*/
	FILE *f;
	f=fopen("test.txt", "w");
	fprintf(f,"***** 영어단어시험 ******\n다음 각 문제에서 영어단어의 뜻을 고르시오.\n");
	for(int i=0;i<ec;i++){
		fprintf(f,"%d. %s\n", i+1, w[e[i]->ex[(e[i]->answer)-1]]->eng);
		for(int j=0;j<4;j++){
			fprintf(f,"%3d) %s\t\t", j+1, w[e[i]->ex[j]]->kor);
			if(j%2==1) fprintf(f,"\n");
		}
	}
	fprintf(f,"\n******정답번호******\n");
	for(int i=0;i<ec;i++)
		fprintf(f,"%2d.(%d) ", i+1, e[i]->answer);
	fprintf(f,"\n");
	fclose(f);
	printf("test.txt에 저장하였습니다.\n");
}
