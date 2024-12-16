package hasierakoak;
/**
 * Compute the sum and average of running integers from a lowerbound to an upperbound using loop.
 */
public class A05SumAverageRunningInt2 {   // Save as "SumAverageRunningInt.java"
   public static void main (String[] args) {
      // Define variables
      int sum = 0;          // The accumulated sum, init to 0
      double average;       // average in double
      final int LOWERBOUND = 1;
      final int UPPERBOUND = 100;
      
      int number = LOWERBOUND;  
      do{
         sum += number;
         ++number; 
      }while (number <= UPPERBOUND);
      average = (double) sum /  UPPERBOUND; // Poniendo (double) delante de sum, hacemos que sum pase a ser un variable double.

      System.out.println("La suma total de los numeros entre " + LOWERBOUND + " y " + UPPERBOUND + ", es: " + sum );
      System.out.println("Y el average es :" + average);

   }
}