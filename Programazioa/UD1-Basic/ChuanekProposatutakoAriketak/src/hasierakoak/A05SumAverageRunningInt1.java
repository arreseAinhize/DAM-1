package hasierakoak;
/**
 * Compute the sum and average of running integers from a lowerbound to an upperbound using loop.
 */
public class A05SumAverageRunningInt1 {   // Save as "SumAverageRunningInt.java"
   public static void main (String[] args) {
      // Define variables
      double sum = 0;          // The accumulated sum, init to 0
      double average;       // average in double
      final double LOWERBOUND = 1;
      final double UPPERBOUND = 100;
      
      double number = LOWERBOUND;        // declare and init loop index variable
      while (number <= UPPERBOUND) {  // test
         sum += number;
         ++number;                    // update
      }
      average = sum / UPPERBOUND;

      System.out.println("La suma total de los numeros entre " + LOWERBOUND + " y " + UPPERBOUND + ", es: " + sum );
      System.out.println("Y el average es :" + average);

   }
}