#include <stdio.h>
int main()
{
    int num, biderketa;
    printf("Zein zenbakiren biderketa taula kalkulatu nahi duzu? "); // Operadorea aukeratu.
    scanf("%i", &num);
    for (int cont = 0; cont <= 10; cont++)
    {
        biderketa = cont * num; // Biderketa de toda la vida
        printf("| %i x %i = %i |", num, cont, biderketa);
    }

    return 0;
}
