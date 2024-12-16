package aceptaelreto;

import java.util.Scanner;

public class FactorialLastDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = in.nextInt();

            int lastDigit;
            if (n >= 5) {
                lastDigit = 0; // Si n >= 5, el último dígito es siempre 0
            } else {
                int factorial = 1;
                for (int i = 1; i <= n; i++) {
                    factorial *= i;
                }
                lastDigit= factorial % 10;
            }

            System.out.println(lastDigit);
        }

        in.close();
    }

}
