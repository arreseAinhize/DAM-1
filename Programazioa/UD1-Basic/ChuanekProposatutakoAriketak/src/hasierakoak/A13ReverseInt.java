package hasierakoak;
import java.util.Scanner;

public class A13ReverseInt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inNumber,inDigit;

        System.err.print("Sartu zenbaki bat: ");
        inNumber = in.nextInt();
        in.close();

        System.out.print("Alderantzizkoa: ");
        while (inNumber > 0){
            inDigit = inNumber%10;
            System.out.print(inDigit);

            inNumber /= 10; // inNumber = inNumber / 10;
        }
    }
}
