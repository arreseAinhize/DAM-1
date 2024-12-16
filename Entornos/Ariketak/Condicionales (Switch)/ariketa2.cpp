#include <stdio.h>
int main(){
    char eguna;

    printf("Sartu egunaren zenbakia(1-7): "); // Operadorea aukeratu.
    scanf("%c", &eguna);

    switch (eguna){
        case '1': // kasu bakoitzerako "programa" rxiki bat idazteko tokia
            printf("Astelehena");
            break;
        case '2':
            printf("Asteartea / Martitzena");
            break;
        case '3':
            printf("Asteazkena / Eguaztena");
            break;
        case '4':
            printf("Osteguna / Eguena");
            break;
        case '5':
            printf("Ostirala / Barikue");
            break;
        case '6':
            printf("Larunbata /Zapatua");
            break;
        case '7':
            printf("Igarndea / Domeka");
            break;
        default:
            /* If operator is other than +, -, * or /, error message is shown */
            printf("Error! Ez dago %c zenbakiarekin bat egiten duen egunik!", eguna);
            break;
    }
    return 0;
}
