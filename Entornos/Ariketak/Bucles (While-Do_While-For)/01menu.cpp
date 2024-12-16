#include <stdio.h>

int main() {
    int num,aukera, count; // GEHIENGO BARIABLEAK "DEKLARATU"
    long long int gehiketa,faktoriala,biderketa; // INT OSO LUZEAK    
    do {
        //Print-ak bata bestearen ostean jarrita kode dena ikus ahal izateko.
        printf("Zer egin nahi duzu? \n 1- Find Sum of Natural Numbers \n 2- Find Factorial of a Number \n 3- Generate Multiplication Table (10)\n");
        printf(" 4- Irten \n Aukeratu: ");
        scanf("%i", &aukera);

        switch (aukera) {
            case 1: { // BATUKETA "NATURALAK"
                printf("Zein zebakiren 'Sum of Natural Numbers' kalkulatu nahi duzu? ");
                scanf("%i", &num);
                gehiketa = 0; 
                for (int cont = 0; cont <= num; cont++) {
                    gehiketa += cont; // gehiketa = gehiketa + cont
                }
                printf("%i zebaki naturalaren batuketa %i da. \n\n", num, gehiketa);
                break;
            }

            case 2: { // FAKTORIALA KALKULATU
                printf("Zein zenbakiren faktoriala kalkulatu nahi duzu? ");
                scanf("%i", &num);
                faktoriala = 1;
                for (int cont = 1; cont <= num; cont++) {
                    faktoriala *= cont; // faktoriala = faktoriala * cont
                }
                printf("%i zebaki faktoriala %i da.\n\n", num, faktoriala);
                break;
            }

            case 3: { // BIDERKETA TAULA
                printf("Zein zenbakiren biderketa taula (10) kalkulatu nahi duzu? ");
                scanf("%i", &num);
                for (int cont = 0; cont <= 10; cont++) {
                    biderketa = cont * num;
                    printf("| %i x %i = %i |", num, cont, biderketa);
                }
                printf("\n\n");
                break;
            }

            case 4: { 
                // IRTEN - BUKLEA BUKATU
                printf("Agur!\n");
                break;
            }

            default: // ERRORE OPZIOA
                printf("Error! Ez dago aukerarik %i zenbakiarekin, zahiatu berriro \n", aukera);
                break;
            }
        } while (aukera != 4); // Aukera 
    return 0;
}