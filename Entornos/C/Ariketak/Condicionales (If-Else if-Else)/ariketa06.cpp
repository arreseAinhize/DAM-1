#include <stdio.h>
int main(){
    int num1;
    printf("Sartu lehenengo zenbakia:");
    scanf("%i", &num1);
    
    if (num1 > 0){ // 0 baino handiagoa
        printf("%i zenbaki positibo bat da.", num1);
    }else if (num1 == 0){ // 0-ren berdina
        printf("%i zenbakia da.", num1);
    }else if (num1 < 0){ // 0 baino txikiagoa
        printf("%i zenbaki negatibo bat da.", num1);
    }else{
        printf("Ez dakit %i zein zenbaki den, barkatu. ", num1);
    }

        return 0;

}
