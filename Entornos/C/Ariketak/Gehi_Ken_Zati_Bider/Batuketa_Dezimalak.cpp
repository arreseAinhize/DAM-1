#include <stdio.h>

int main(){
   float num1,num2,num3,emaitza;
   
   printf("Sartu lehenengo zenbakia:  ");
   scanf("%f",&num1); 

   printf("Sartu bigarren zenbakia: ");
   scanf("%f",&num2); 
   
   printf("Sartu azken zenbakia: ");
   scanf("%f",&num3); 
   
   emaitza= num1+num2+num3;
   
   printf("%.2f + %.5f + %f batuketaren ebaitza, hau da: %f",num1,num2,num3,emaitza);
}

