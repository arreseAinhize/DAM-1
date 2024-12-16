#include <stdio.h>

int main(){
   int num1,num2,num3,emaitza;
   
   printf("Sartu lehenengo zenbakia:  ");
   scanf("%i",&num1); 

   printf("Sartu bigarren zenbakia: ");
   scanf("%i",&num2); 
   
   printf("Sartu azken zenbakia: ");
   scanf("%i",&num3); 
   
   emaitza= num1*num2*num3;
   
   printf("%i * %i * %i biderketaren emaitza, hau da: %i",num1,num2,num3,emaitza);
}
