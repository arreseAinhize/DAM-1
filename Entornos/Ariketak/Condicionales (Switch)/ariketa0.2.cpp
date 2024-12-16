#include <stdio.h>

int main() {
    char eguna;
    char mota;

    printf("Sartu egunaren zenbakia(1-7): "); // Operadorea aukeratu.
    scanf(" %c", &eguna); // Se añade un espacio antes de %c para ignorar espacios en blanco.
    printf("Aukeratu egunak nola nahi dituzun: Bizkaieraz(B)/Batueraz(G): "); // Operadorea aukeratu.
    scanf(" %c", &mota); // Igual aquí, para el segundo scanf.

    switch (mota) {
        case 'B':
            switch (eguna) {
                case '1':
                    printf("Astelehena");
                    break;
                case '2':
                    printf("Martitzena");
                    break;
                case '3':
                    printf("Eguaztena");
                    break;
                case '4':
                    printf("Eguena");
                    break;
                case '5':
                    printf("Barikue");
                    break;
                case '6':
                    printf("Zapatua");
                    break;
                case '7':
                    printf("Domeka");
                    break;
                default:
                    printf("Error! Ez dago %c zenbakiarekin bat egiten duen egunik!", eguna);
                    break;
            }
            break;
        case 'G':
            switch (eguna) {
                case '1':
                    printf("Astelehena");
                    break;
                case '2':
                    printf("Asteartea");
                    break;
                case '3':
                    printf("Asteazkena");
                    break;
                case '4':
                    printf("Osteguna");
                    break;
                case '5':
                    printf("Ostirala");
                    break;
                case '6':
                    printf("Larunbata");
                    break;
                case '7':
                    printf("Igandea");
                    break;
                default:
                    printf("Error! Ez dago %c zenbakiarekin bat egiten duen egunik!", eguna);
                    printf("Gogoratu egunaren zenbakia 1etik 7ra izan behar duela");
                    break;
            }
            break;
        default:
            printf("Error! Ezin da hautatutako mota interpretatu.");
            printf("Gogoratu B edo G izan behar duela, letra larriz.");
            break;
    }

    return 0;
}
