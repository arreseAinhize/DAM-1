#include <stdio.h>
#include <math.h>

int main() {
    float a, b, c, discriminant, realPart, imaginaryPart, res1, res2;

    printf("Sartu lehenengo zenbakia: ");
    scanf("%f", &a);
    printf("Sartu bigarren zenbakia: ");
    scanf("%f", &b);
    printf("Sartu hirugarren zenbakia: ");
    scanf("%f", &c);

    

    // Si el discriminante es positivo o cero
    if (discriminant >= 0) {
        res1 = (-b + sqrt(discriminant)) / (2 * a);
        res2 = (-b - sqrt(discriminant)) / (2 * a);
        printf("Erantzunak %f eta %f dira.\n", res1, res2);
    }
    // Si el discriminante es negativo, resultado con números imaginarios
    else {
        realPart = -b / (2 * a);
        imaginaryPart = sqrt(-discriminant) / (2 * a);
        printf("Erantzunak: %f + %fi eta %f - %fi dira.\n", realPart, imaginaryPart, realPart, imaginaryPart);
    }

        return 0;

}
