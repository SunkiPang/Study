#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(void){
    int cnt = 1, i, j;
    char *a = (char*)malloc(sizeof(char)*4);
    char *b = (char*)malloc(sizeof(char)*4);

    srand(time(NULL));

    for(i = 0; i<4; i++){
        a[i] = rand()%9;
        for(j = 0; j<i; j++){
            if(a[i] == a[j]){
                i--;
                break;
            }
        }

    }
    for(i = 0; i<4; i++)
        printf(" %d ", a[i]);

    while(1){

        int S = 0, B = 0;

        printf("\nLET'S PLAY BASSBALL GAME! ROUND %d\n", cnt);
        printf("Enter the number: ");
        gets(b);

        for(i = 0; i<4; i++){
            if(a[i] == b[i])
                S++;
        }
        printf("\nthe number %d", S);



        if(S == 4){
            printf("Homerun!, %d round", cnt);
            break;
        }
        else{
            printf("%dS and %dB", S, B);
            cnt++; break;
        }
    }
    return 0;
}
