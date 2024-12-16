package hasierakoak;
import java.util.Scanner;

public class A08ExtractDigits1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // "escanea" los input del teclado
        int n;
        System.out.print("Inserte un numero para extraer sus digitos: ");  // No newline for prompting message
        n = in.nextInt();  // Read next input as "int"
        in.close();  // Close Scanner
        
        while (n > 0) {
            int digit = n % 10;  // Extract the least-significant digit
            // Print this digit
            System.out.print(digit + " ");
            n = n / 10;  // Drop the least-significant digit and repeat the loop
        }
    }
}
