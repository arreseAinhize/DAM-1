package hasierakoak.oinarria;
/*
 * Test Arithmetic Operations
 */
public class Sum2 {     // Save as "ArithmeticTest.java"
    public static void main(String[] args) {
        int number1 = 98; // Declare an int variable number1 and initialize it to 98
        int number2 = 5;  // Declare an int variable number2 and initialize it to 5
        int sum, difference, product, quotient, remainder, sum1;  // Declare 5 int variables to hold results
    
        // Perform arithmetic Operations
        sum = number1 + number2;
        difference = number1 - number2;
        product = number1 * number2;
        quotient = number1 / number2;
        remainder = number1 % number2;
        sum1= number1*31 + number2*17;
        // Print results
        System.out.print("The sum, difference, product, quotient and remainder of " + number1 + " and " + number2 + " are " + sum + ", " + 
        difference + ", " + product + ", " + quotient +", and " + remainder );  // Print description
        System.out.println("La suma de 31 veces " + number1 + "y 17 veces " + number2 + "es: " + sum1);
        
        ++number1;  // Increment the value stored in the variable "number1" by 1
                  // Same as "number1 = number1 + 1"
        --number2;  // Decrement the value stored in the variable "number2" by 1
                  // Same as "number2 = number2 - 1"
        System.out.println("number1 after increment is " + number1);  // Print description and variable
        System.out.println("number2 after decrement is " + number2);
        quotient = number1 / number2; 
        System.out.println("The new quotient of " + number1 + " and " + number2 
            + " is " + quotient);
    }
}
