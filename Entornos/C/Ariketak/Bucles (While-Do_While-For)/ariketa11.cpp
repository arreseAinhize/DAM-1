/*
 * Check whether a number is prime or not
 */
#include <stdio.h>
int main(){
    printf("ZENBAKI LEHENA DA EDO EZ?\n");
    int num, i;
    printf("Sartu egiaztatu nahi duzun zenbakia: ");
    scanf("%d", &num);

    if (num == 1 || num == 0){
        printf("%d ez da zenbaki lehen bat.\n\n", num);
    }else{
        for (i = 2; i < num; i++){ // Iterar num-1 arte.
            if (num % i == 0){//I-ren balioaz zatitzean ondarra 0 bada
                printf("%d ez da zenbaki lehen bat.\n\n", num);
                break;
            }
        }
        if (i == num){
            printf("%d zenbaki lehen bat da.\n\n", num);
        }
    }
    return 0;
}
