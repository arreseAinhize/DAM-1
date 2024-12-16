package hasierakoak;
/**
 * Compute the sum and average of running integers from a lowerbound to an upperbound using loop.
 */
public class A05SumAverageRunningInt5 {   // Save as "SumAverageRunningInt.java"
   public static void main (String[] args) {
      // Define variables
      int par = 0; 
      int impar = 0; 
      int absDiff;

      final int LOWERBOUND = 1;
      final int UPPERBOUND = 100;

      for(int i =  LOWERBOUND ; i<=UPPERBOUND;i++){
         if(i % 2 == 0){
            par += i;
         }else{
            impar += i;
         }
      }
      if (par > impar){
         absDiff = par - impar; // calcula la diferencia (en este caso los pares son mayoria por li que el calculo final sera una numero positivo.)
      }else{
         absDiff = impar - par; // calcula la diferencia (en este caso los impares son mayoria por li que el calculo final sera una numero positivo.)

      }
      System.out.println("La suma total de los pares es: " + par + " y de los impares es: " + impar);
      System.out.println("Por otro lado, la diferencia total es: " + absDiff);
   }
}