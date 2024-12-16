#include <stdio.h>
int main(){
    int num1, num2, num3;
    printf("Sartu lehenengo zenbakia:");
    scanf("%i", &num1);
    printf("Sartu bigarren zenbakia:");
    scanf("%i", &num2);
    printf("Sartu hirugarren zenbakia:");
    scanf("%i", &num3);
    
    if (num1 > num2 && num1 > num3){ // num2 baino handiagoa eta num3 baino handiagoa
        printf("%i zenbaki handiena da.", num1);
    }else if (num2 > num3 && num2 > num1){ // num1 baino handiagoa eta num3 baino handiagoa
        printf("%i zenbaki handiena da.", num2);
    }else if (num3 > num2 && num3 > num1){ // num2 baino handiagoa eta num1 baino handiagoa
        printf("%i zenbaki handiena da.", num3);
    }else if (num3 == num2 && num3 == num1){
        printf("Hiru zenbakiak berdinak dira. 1- %i , 2- %i , 3- %i", num1, num2, num3);
    }else{
        printf("Ez dakit zein den zenbakirik handiena, barkatu. 1- %i , 2- %i , 3- %i", num1, num2, num3);
    }
    
    return 0;
}
