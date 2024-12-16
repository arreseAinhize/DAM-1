#include <stdio.h>
#include <math.h>

int main() {
    int num,aukera, count, digit; // GEHIENGO BARIABLEAK "DEKLARATU"
    long int gehiketa,faktoriala,biderketa; // INT LUZEAK
    do {
        //Print-ak bata bestearen ostean jarrita kode dena ikus ahal izateko.
        printf("\nZer egin nahi duzu? \n 1- Find Sum of Natural Numbers \n 2- Find Factorial of a Number \n 3- Generate Multiplication Table (10)\n");
        printf(" 4- Reverse a Number \n 5- Calculate the power of a number \n 6- Check wheather a number is prime or not \n");
        printf(" 7- Fibonacci \n 8- Circle Computation \n 9- Draw something \n 10- Irten \n Aukeratu: ");
        scanf("%i", &aukera);

        switch (aukera) {
            case 1: { // BATUKETA "NATURALAK"
                printf("Zein zebakiren 'Sum of Natural Numbers' kalkulatu nahi duzu? ");
                scanf("%i", &num);
                gehiketa = 0; 
                int cont = 0;
                while (cont <= num){
                    gehiketa += cont; // gehiketa = gehiketa + cont
                    cont++;
                }
                
                printf("%i zebaki naturalaren batuketa %i da. \n\n", num, gehiketa);  // <-- bukaerako \n\n == Esteticamente hobeto geratzeko
                break;
            }

            case 2: { // FAKTORIALA KALKULATU
                printf("Zein zenbakiren faktoriala kalkulatu nahi duzu? ");
                scanf("%i", &num);
                faktoriala = 1;
                for (int cont = 1; cont <= num; cont++) {
                    faktoriala *= cont; // faktoriala = faktoriala * cont
                }
                printf("%i zebaki faktoriala %i da.\n\n", num, faktoriala);  // <-- bukaerako \n\n == Esteticamente hobeto geratzeko
                break;
            }

            case 3: { // BIDERKETA TAULA
                printf("Zein zenbakiren biderketa taula kalkulatu nahi duzu? ");
                scanf("%i", &num);
                for (int cont = 0; cont <= 10; cont++) {
                    biderketa = cont * num;
                    printf("| %i x %i = %i |", num, cont, biderketa);
                }
                printf("\n\n"); // <-- Esteticamente hobeto geratzeko
                break;
            }

            case 4:{ // ZENBAKIA BIRATU
                printf("Sartu zenbaki bat bira emateko: ");
                scanf("%i", &num);
                printf("Hau da zure zenbaki berria: ");
                do{
                    digit = num % 10; // <-- Zati 10 ein eita ondarra atara --- adb. --- 12 % 10 = 2
                    printf("%i",digit); // <--  "ondarra" imprimido --- adb. --- 2
                    num = num / 10; // <-- azken digitua kendu --- adb. --- 12/10 = 1 (zenbaki osoak [int])
                }while (num > 0);           
                printf("\n\n"); // <-- Esteticamente hobeto geratzeko
                break;
            }

            case 5: { // BERREKETA KALKULATU
                int berrekizuna, berretzailea, emaitza = 1;
                printf("Sartu berrekizunaren balioa: ");
                scanf("%i", &berrekizuna);
                printf("Sartu berretzailearen balioa: ");
                scanf("%i", &berretzailea);
                int cont = 1; 
                while (cont <= berretzailea) {
                    //math.h direktorioa gehitu eta pow() erabiliz 
                    emaitza *= berrekizuna; // emaitza = emaitza * berrekizuna
                    cont++;
                }
                printf("%i^%i berreketaren emaitza %i da.\n\n", berrekizuna, berretzailea, emaitza);  // bukaerako \n\n --> Esteticamente hobeto geratzeko
                break;
            }

            case 6: {//ZENBAKI LEHENAK
                int i;
                printf("Sartu egiaztatu nahi duzun zenbakia: ");
                scanf("%d", &num);
                if (num == 1 || num == 0) {
                    printf("%d ez da zenbaki lehen bat.\n\n", num);
                } else {
                    //2-tik hasten da, 0 eta 1 kasuek gohien deskartatu direlako
                    for (i = 2; i < num; i++) { // Iterar num-1 arte.  <-- i=2;i<num/2;i++ son iguales
                        if (num % i == 0) {//I-ren balioaz zatitzean ondarra 0 bada
                            printf("%d ez da zenbaki lehen bat.\n\n", num);  // bukaerako \n\n --> Esteticamente hobeto geratzeko
                            break;
                        }
                    }
                    if (i == num) {
                        printf("%d zenbaki lehen bat da.\n\n", num);  // bukaerako \n\n --> Esteticamente hobeto geratzeko
                    }
                }
                break;
            }

            case 7:{
                int n = 3, fn, fnMinus1 = 1, fnMinus2 = 1,nMax = 20;
                // The index n for F(n), starting from n=3, as n=1 and n=2 are pre-defined
                // F(n) to be computed  // F(n-1), init to F(2) // F(n-2), init to F(1) // maximum n, inclusive
                printf("Lehenengo %i Fibonacci zenbakiak: ",nMax);
                for(int n = 3;n<=nMax;n++){
                    fn = fnMinus1 + fnMinus2;
                    printf(" %i",fn);
                    fnMinus2 = fnMinus1;
                    fnMinus1 = fn;
                }
                printf("\n\n");
                break;
            }

            case 8:{ //ZIRKUNFERENTZIAREN KALKULUAK
                double erradioa,diametroa,azalera,zirkunferentzia;
                printf("Aukeratu zirkunferentziaren erradioa: ");
                scanf("%d", &erradioa);
                diametroa = 2.0 * erradioa;
                azalera = M_PI * erradioa * erradioa; // M_PI (math.h) --> pi ren balioa == 3.1415...
                zirkunferentzia = 2.0 * M_PI * erradioa;
                printf("Diameter is: %d \n", diametroa);
                printf("Area is: %d \n", azalera);
                printf("Circumference is: %d \n", zirkunferentzia);
                break;
            }

            case 9:{ // MARRAZKIAK EGIN
                char marrazkia;
                int size;
                do{
                    printf("\nZer Marraztu nahi duzu? \n a) Laukia \n b) Triangelua \n c) Marrazteari usteko \n Aukeratu: ");
                    scanf(" %c", &marrazkia);
                    switch (marrazkia){
                        case 'a':{
                            printf("Aukeratu karratuaren zabalera: ");
                            scanf("%i", &size);
                                for (int row = 1; row <= size; row++) {
                                    for (int col = 1; col <= size; col++) {  
                                        printf(" * ");   
                                    }
                                    printf("\n");   
                                }
                                break;
                        }

                        case 'b':{
                            printf("\n Zenbateko triangelua nahi duzu? \n");
                            scanf(" %i", &size);
                            for (int row = 1; row <= size; row++) {  
                                for (int col = 1; col <= size; col++) {  // col = 1, 2, 3, ..., size
                                    if (row >= col) {
                                        printf("* ");
                                    } else {
                                        printf("  ");  // Need to print the "leading" blanks
                                    }
                                }
                                // Print a newline after printing all the columns
                                printf("\n");
                            }
                            break;
                        }

                        case 'c':{
                            printf("Agur!\n");
                            break;
                        }

                        default:{
                            printf("Error! Ez dago aukerarik %c-rekin. \n", marrazkia);
                            break;
                        }                            
                    }
                }while(marrazkia != 'c');
            }

            case 10: { // IRTEN
                printf("Agur!\n");
                break;
            } 

            default: { // ERRORE OPZIOA
                printf("Error! Ez dago aukerarik %i zenbakiarekin, zahiatu berriro \n", aukera);
                break;
            }
        }
    } while (aukera != 10); // BUKLEA BUKATU
    return 0;
}