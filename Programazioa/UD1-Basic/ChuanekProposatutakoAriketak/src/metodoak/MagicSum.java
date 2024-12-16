package metodoak;
/*
Write a boolean method called hasEight(), which takes an int as input and returns true if the number contains the digit 8 (e.g., 18, 168, 1288). The signature of the method is as follows:

public static boolean hasEight(int number);
Write a program called MagicSum, which prompts user for integers (or -1 to end), and produce the sum of numbers containing the digit 8. Your program should use the above methods. A sample output of the program is as follows:

Enter a positive integer (or -1 to end): 1
Enter a positive integer (or -1 to end): 2
Enter a positive integer (or -1 to end): 3
Enter a positive integer (or -1 to end): 8
Enter a positive integer (or -1 to end): 88
Enter a positive integer (or -1 to end): -1
The magic sum is: 96
 */

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        final int SENTINEL = -1;  // Terminating input
        int number,sum=0;
        Scanner in = new Scanner(System.in);
        // Read first input to "seed" the while loop
        System.out.print("Enter a positive integer (or -1 to end): ");
        number = in.nextInt();

        while (number != SENTINEL) {  // Repeat until input is -1
            // Read next input. Repeat if the input is not the SENTINEL 
            // Take note that you need to repeat these codes!
            if (number < 0){
                System.out.println("Input incorrecto, recuerda meter un numero positivo o -1 para terminar! ");
                System.out.print("Enter a positive integer (or -1 to end): ");
                number = in.nextInt();
            }else{
                if (hasEight(number)) { //Si, retunr = true
                    sum += number;
                }
                System.out.print("Enter a positive integer (or -1 to end): ");
                number = in.nextInt();
            }
        }
        in.close();
        if(sum !=0){
            System.out.println("The magic sum is: " + sum);
        }else{
            System.out.println("There is not a magic sum");
        }
    }
    public static boolean hasEight(int number){
        boolean hasEight = false;
        while (number > 0) { // Solo numeros positivos
            if (number % 10 == 8) {
                hasEight = true;
            }
            number /= 10;
        }
        return hasEight;
    }
}
