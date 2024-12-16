package metodoak;
import java.util.Scanner;

public class Exponent {
    public static void main(String[] args) {
        int exp, base;
        Scanner in = new Scanner(System.in);

        System.err.println("Enter de valu of the exponent: ");
        exp = in.nextInt();
        System.err.println("Enter de valu of the base: ");
        base = in.nextInt();
        exponente(base,exp);
        in.close();
        System.out.println(base + " raises to the power of " + exp + " is: " + exponente(base, exp));
    }
       // Returns "base" raised to the power "exp"
    public static int exponente(int base, int exp) {
    int product = 1;   // resulting product
    // Multiply product and base for exp number of times
    for (int i=1;i<=exp;i++) {
        product *= base;
    }
    // for (product=1;product<=exp;product++) {
    //      product *= base;
    // Hau ein eskero bukaeran product 7 ixengo da for a rrecorritzeko erabiltzen dalako.
    // }
    return product;
    }
}
