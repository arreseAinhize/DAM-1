package hasierakoak;
/**
 * Print first 20 Fibonacci numbers and their average
 */
public class A07Fibonacci {
    public static void main (String[] args) {
        int n = 3;          // The index n for F(n), starting from n=3, as n=1 and n=2 are pre-defined
        int fn;             // F(n) to be computed
        int fnMinus1 = 1;   // F(n-1), init to F(2)
        int fnMinus2 = 1;   // F(n-2), init to F(1)
        int nMax = 20;      // maximum n, inclusive
        int sum = fnMinus1 + fnMinus2;  // Need sum to compute average
        double average;
    
        System.out.println("The first " + nMax + " Fibonacci numbers are:");
        System.out.print(fnMinus1 + " " +fnMinus2);
    
            while (n <= nMax) {  // n starts from 3
                fn = fnMinus1 + fnMinus2;
               // n = 3, 4, 5, ..., nMax
                System.out.print(" " + fn);               
                sum += fn;
               // Compute F(n), print it and add to sum
                // Increment the index n and shift the numbers for the next iteration
                ++n;
                fnMinus2 = fnMinus1;
                fnMinus1 = fn;
            }
            average = (double) sum/nMax;
            System.out.println(" The average is: "+average);               

        }
    // Compute and display the average (=sum/nMax).
    // Beware that int/int gives int.
    
}
