/*
 * Find sum of natural numbers
 */
#include <stdio.h>
int main()
{
    int num, gehiketa;
    printf("Zein zebakiren 'Sum of Natural Numbers' kalkulatu nahi duzu?"); // Operadorea aukeratu.
    scanf("%i", &num);
    for (int cont = 0; cont <= num; cont++)
    {
        gehiketa += cont;
    }
    printf("%i zebaki naturalaren batuketa %i da. \n", num, gehiketa);

    return 0;
}
