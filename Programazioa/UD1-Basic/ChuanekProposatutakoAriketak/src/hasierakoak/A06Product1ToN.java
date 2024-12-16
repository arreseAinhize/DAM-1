package hasierakoak;
public class A06Product1ToN {
    public static void main(String[] args) {
        // Define variables
        int product = 1;      // The accumulated product, init to 1
        final int LOWERBOUND = 1;
        final int UPPERBOUND = 10;

        for(int i = LOWERBOUND ; i <= UPPERBOUND; i++){
            product *= i; // Calcula el factorial
        }

        System.out.println("El producto de los enteros del "+ LOWERBOUND+ " al " + UPPERBOUND+" es: " + product);

    }
    
}