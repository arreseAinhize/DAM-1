#include <stdio.h>
int main(){
    int num1;
    printf("Sartu lehenengo zenbakia:");
    scanf("%i", & num1);

    if(num1 % 2 == 0){
        printf("%i zenbaki bikoitia da.");
    }else{
        printf("%i zenbaki bakoitia da.");
    }

        return 0;

}