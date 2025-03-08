#include<stdio.h>
#include <ctype.h> // Para usar tolower()

int main(){
    char cv;
    printf("Sartu karaktere bat:");
    scanf("%c", & cv);

    int lower = tolower(cv);     // Convertimos el carácter a minúscula

    if (cv >= '0' && cv <= '9') {   // Verificamos si es un número (0-9)
        printf("%c zenbaki bat da.\n", cv);
    } else if (lower >= 'a' && lower <= 'z') {    // Verificamos si es una letra del alfabeto (minúscula o mayúscula)
        if((lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u')){
            printf("%c bokal bat da.",cv);
        }else{
            printf("%c konsonante bat da.",cv);
        }
    } else {                                      // Si no es un número ni una letra, es otro tipo de carácter
        printf("%c beste karaktere bat da.\n", cv);
    }

        return 0;

}