package hasierakoak;
import java.util.Scanner;

public class A15InputValidation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Declare variables
        int numberIn;      // to be input
        boolean isValid;   // boolean flag to control the loop
        //......
        
        // Use a do-while loop controlled by a boolean flag 
        // to repeatably read the input until a valid input is entered
        isValid = false;   // default assuming input is not valid
        do {
            // Prompt and read input
            System.out.println("Sartu balio bat, 0-10 edo 90-100 tartean dagoena: ");
            numberIn = in.nextInt();
            // Validate input by setting the boolean flag accordingly
            if ((numberIn > 0 && numberIn < 10) || (numberIn > 90 && numberIn < 100)) {
                in.close();
                System.out.println(numberIn + " sartu duzu!");  // Print error message and repeat
                isValid = true;   // exit the loop
            } else {
                System.out.println("Sarrera baliogabea, saiatu berriro...");  // Print error message and repeat
            }
        } while (!isValid);
    }
}
