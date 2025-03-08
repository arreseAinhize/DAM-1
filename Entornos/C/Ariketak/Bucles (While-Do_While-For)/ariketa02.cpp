/*
 * Find factorial of a number
 */
#include <stdio.h>
int main()
{
    int num, faktoriala;
    faktoriala = 1;

    printf("Zein zenbakiren faktoriala kalkulatu nahi duzu? "); // Operadorea aukeratu.
    scanf("%i", &num);
    for (int cont = 1; cont <= num; cont++)
    {
        faktoriala *= cont;
    }
    printf("%i zebaki faktoriala %i da.\n", num, faktoriala);
    return 0;
}
