#include <stdio.h>
int main(){
    char o;
    float num1, num2;
    printf("Select an operator either + or - or * or / \n"); //Operadorea aukeratu.
    scanf("%c", &o);

    printf("Enter two operands: "); //Zenbakiak eskatu
    scanf("%f%f", &num1, &num2);

    switch (o){
        case '+': //kasu bakoitzerako "programa" rxiki bat idazteko tokia
            printf("%.1f + %.1f = %.1f", num1, num2, num1 + num2);
            break;
        case '-':
            printf("%.1f - %.1f = %.1f", num1, num2, num1 - num2);
            break;
        case '*':
            printf("%.1f * %.1f = %.1f", num1, num2, num1 * num2);
            break;
        case '/':
            printf("%.1f / %.1f = %.1f", num1, num2, num1 / num2);
        default:
            /* If operator is other than +, -, * or /, error message is shown */
            printf("Error! operator is not correct");
            break;
    }
    return 0;
}
