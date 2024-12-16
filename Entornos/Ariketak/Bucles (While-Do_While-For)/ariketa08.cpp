#include <stdio.h>
int main(){
    int num,digit=0;
    printf("Sartu zenbaki bat bere digituak zenbatzeko: ");
    scanf("%i", &num);
    printf("Hau da zure zenbaki berria: ");
    if(num==0)
    {
        printf("%i",num);
    }else
    {
        while (num > 0)
        {
            digit = num % 10; // <-- Zati 10 ein eita ondarra atara
            printf("%i",digit); // <--  "ondarra" imprimido
            num = num / 10; // <-- azken digitua kendu
        }
    }           
    return 0;
}