package hasierakoak;
import java.util.Scanner;

public class A14SumOfDigitsInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inNumber,inDigit,sum = 0;

        System.err.print("Sartu zenbaki bat: ");
        inNumber = in.nextInt();
        in.close();

        System.out.print("Zenbakien gehiketa: ");
        while (inNumber > 0){
            inDigit = inNumber%10;
            sum += inDigit; // sum = sum + inDigit;
            inNumber /= 10; // inNumber = inNumber / 10;
        }
        System.out.print(sum);

    }
}
