#include <stdio.h> // Para usar scanf() y printf()
#include <math.h> // Para usar sqrt() <-- Errokarratu
int main(){

    float a,b,c,r1,r2,res1,res2;

    printf("Sartu lehenengo zenbakia:");
    scanf("%f", &a);
    printf("Sartu bigarren zenbakia:");
    scanf("%f", &b);
    printf("Sartu hirugarren zenbakia:");
    scanf("%f", &c);

    //R1 eta R2 berdinak.
    r1= sqrt((b*b)-(4*a*c));
    r2= sqrt((b*b)-(4*a*c));   
    //IF-ELSE --> erro barrukoa negatiboa bada errore mezu bat atera dadin.
    if(r1 >= 0){
        res1= (-b +r1 )/(2*a);
        res2=((-b -r1 )/(2*a));
        printf("Erantzunak %f eta %f dira.",res1,res2);
    }else{
        printf("Erro barruan ezin da zenbaki negatiborik izan eragiketen bukaeran!");
    }
    return 0;
}