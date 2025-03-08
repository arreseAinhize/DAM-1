/*
* Calculate the power os a number
*/
#include <stdio.h>
int main()
{
    int berrekizuna,berretzailea,emaitza = 1;
    printf("Sartu berrekizunaren balioa: ");
    scanf("%i", &berrekizuna);
    printf("Sartu berretzailearen balioa: ");
    scanf("%i", &berretzailea);
    int cont = 1; 
    while (cont <= berretzailea){
        //math.h direktorioa gehitu eta pow() erabiliz 
        emaitza *= berrekizuna; // emaitza = emaitza * berrekizuna
        cont++;
    }
    printf("%i^%i berreketaren emaitza %i da.",berrekizuna,berretzailea,emaitza);
    return 0;
}