package hasierakoak.oinarria;
public class Sum3 {
    public static void main(String[] args) {
        int number1 = 98; // Declare an int variable number1 and initialize it to 98
        int number2 = 5;  // Declare an int variable number2 and initialize it to 5
        int number3 = 77;
        int sum, difference, product, quotient, remainder;  // Declare 5 int variables to hold results
    
        // Perform arithmetic Operations
        sum = number1 + number2 + number3;
        difference = number1 - number2 - number3;
        product = number1 * number2 * number3;
        quotient = number1 / number2 / number3;
        remainder = number1 % number2 %number3;
        // Print results
        System.out.println("The sum, difference, product, quotient and remainder of " + number1 + " , " + number2 + " and " + number3 +" are: " + sum + ", " + 
        difference + ", " + product + ", " + quotient +", and " + remainder );  // Print description
    }   
}
