package hasierakoak;
import java.util.Scanner;

public class A16AverageWithInputValidation {
    public static void main(String[] args) {
        // Declare constant
        final int NUM_STUDENTS = 3;
        Scanner in = new Scanner(System.in);

        // Declare variables
        int numberIn;
        boolean isValid;   // boolean flag to control the input validation loop
        int sum = 0;
        double average;
        
        for (int studentNo = 1; studentNo <= NUM_STUDENTS; ++studentNo) {
            // Prompt user for mark with input validation
            System.out.println("Sartu " + studentNo +". ikaslearen nota (0-100): ");
            numberIn = in.nextInt();
            isValid = false;   // default assuming input is not valid
            do {
                // Prompt and read input
                // Validate input by setting the boolean flag accordingly
                if ((numberIn >= 0 && numberIn <= 100)) {   
                    System.out.println( "Hiru ikasleen markak gorde dira.");  // Print error message and repeat
                    isValid = true;   // exit the loop
                } else {
                    System.out.println("Sarrera baliogabea, saiatu berriro...");  // Print error message and repeat
                    System.out.println("Sartu " + studentNo +". ikaslearen nota (0-100): ");
                    numberIn = in.nextInt();
                }
            } while (!isValid);
            
            sum += numberIn;
        }
        in.close();
        average = (double)sum/NUM_STUDENTS;
        System.out.println("Ikaslehen noten batas bestekoa " + average + " da.");
    }
}
