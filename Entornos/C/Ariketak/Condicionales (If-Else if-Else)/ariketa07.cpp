#include <stdio.h> // Para usar scanf() y printf()
#include <ctype.h> // Para usar tolower()

int main() {
    int character;

    printf("Ingresa un carácter: ");
    scanf(" %c", (char *)&character);  // scanf() pkaraktereak irakurtzeko,  (char *)&XXX karaktere metako datuak irakurtzeko.
    
    int lower = tolower(character); //karakteraak minuskulara pasatu    

    if (character >= '0' && character <= '9') { 
        // Verificamos si es un número (0-9)  
        printf("%c es un número.\n", character);       
    } else if (lower >= 'a' && lower <= 'z') { 
        // Verificamos si es una letra del alfabeto (minúscula o mayúscula)   
        printf("%c es una letra del alfabeto.\n", character);
    } else { 
        // Si no es un número ni una letra, es otro tipo de carácter
        printf("%c es otro tipo de carácter.\n", character);
    }

        return 0;

}
