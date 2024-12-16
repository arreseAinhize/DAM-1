package hasierakoak;
import java.util.Scanner;
public class A12Swap2Integers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x,y;
        int temp;

        System.out.print("Sartu lehenengo zenbakia: ");
        x = in.nextInt();  // read input as int
        System.out.print("Sartu bigarren zenbakia: ");
        y = in.nextInt();
        in.close();

        System.out.println("");
        System.out.println("Lehenengo zenbakia " +x);
        System.out.println("Bigarren zenbakia "+y);
        // intercambia los valores de X e Y
        temp = x;
        x = y;
        y = temp; 

        System.out.println("");
        System.out.printf("Aldaketak egin ostean lehenengo zenbakia " + x + " da, eta bigarren zenbakia " + y);
    }
}
