package hasierakoak;

import java.util.Scanner;

public class A10SumProductMinMax3 {
    public static void main(String[] args) {
        // Declare variables
        int number1, number2, number3,sum, product;     // To compute these
        
        // Prompt and read inputs as "int"
        Scanner in = new Scanner(System.in);  // Scan the keyboard
        System.out.println("Sartu lehenengo zenbakia: ");
        number1 = in.nextInt();
        System.out.println("Sartu bigarren zenbakia: ");
        number2 = in.nextInt();
        System.out.println("Sartu hirugarren zenbakia: ");
        number3 = in.nextInt();
        in.close();
        
        // Compute sum and product
        sum = number1 + number2 + number3;
        product = number1*number2*number3;
        System.out.println("Zenbaki guztien batura " + sum + " da.");
        System.out.println("Zenbaki guztien bidekadura " + product + " da.");

        // Compute min
        if (number2 < number1) {  // Check if the 2nd item is smaller than current min
            if(number3 < number1){
                System.out.println("Zenbaki txikiena " + number3 + " da.");
            }else{
                System.out.println("Zenbaki txikiena " + number2 + " da.");
            }
        }else{
            if(number1 < number3){
                System.out.println("Zenbaki txikiena " + number1 + " da.");
            }
        }

        // Compute max - similar to min
        if(number3 < number2){
            if(number1 < number2){
                System.out.println("Zenbaki handiena " + number2 + " da.");
            }
            
        }else if (number2 < number3){
            if(number1 < number3){
                System.out.println("Zenbaki handiena " + number3 + " da.");
            }else{
                System.out.println("Zenbaki handiena " + number1 + " da.");
            }
        }else{
            System.out.println("Zenbaki handiena " + number1 + " da.");
        }
        
    }
}
