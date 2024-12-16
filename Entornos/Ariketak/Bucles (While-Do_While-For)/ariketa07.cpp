/*
 * Count numer of digits of an integer
 */
#include <stdio.h>
int main(){
    int num, count;
    printf("Sartu zenbaki bat bere digituak zenbatzeko: ");
    scanf("%i", &num);
    count = 0; 
    if (num == 0){
        count = 1; // zenbakia 0 bada, digito bat du.
    }else{
        while (num != 0){
            num = num / 10; // <-- azken digitua kendu
            count++; // count = count +1
        }
    }
    printf("Digitu kopurua, %d da.\n\n", count);
    return 0;
}