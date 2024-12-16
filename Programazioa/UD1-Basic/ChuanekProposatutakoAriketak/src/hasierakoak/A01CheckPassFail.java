package hasierakoak;
/**
 * Trying if-else statement.
 */

public class A01CheckPassFail {  // Save as "CheckPassFail.java"
   public static void main(String[] args) {  // Program entry point
      int mark = 100;   // Set the value of "mark" here!
      System.out.print("The mark is " + mark + " ");

      // if-else statement
      if ( mark >= 50 ) {
         System.out.println( " PASS" );
      } else {
         System.out.println( "FAIL" );
      }
      System.out.println( "DONE" );
   }
}