package hasierakoak;
/**
 * Trying nested-if and switch-case statements.
 */
public class A03PrintNumberInWord {   // Save as "PrintNumberInWord.java"
   public static void main(String[] args) {
      int number = 5;  // Set the value of "number" here!

      // Using nested-if
      if (number == 1) {   // Use == for comparison
         System.out.println( "BAT" );
      } else if ( number == 2 ) {
         System.out.println("BI");

      } else if ( number == 3 ) {
         System.out.println("HIRU");

      } else if(number == 4){
         System.out.println("LAU");

      } else if (number == 5) {
         System.out.println("BOST");

      }else if (number == 6) {
         System.out.println("SEI");

      }else if (number == 7) {
         System.out.println("ZAZPI");

      }else if (number == 8) {
         System.out.println("ZORTZI");

      }else if (number == 9) {
         System.out.println("BEDERATZI");

      }else{
         System.out.println("BESTEAK");
      }

      number = 9;
      // Using switch-case-default
      switch(number) {
         case 1: 
            System.out.println( "BAT" ); break;  // Don't forget the "break" after each case!
         case 2: 
            System.out.println( "BI" ); break;
         case 3: 
            System.out.println( "HIRU" ); break;
         case 4: 
            System.out.println( "LAU" ); break;
         case 5:
            System.out.println("BOST"); break;
         case 6:
            System.out.println("SEI");break;
         case 7:
            System.out.println("ZAZPI");break;
         case 8:
            System.out.println("ZORTZI");break;
         case 9:
            System.out.println("BEDERATZI");break;
         default: System.out.println( "BESTEREN BAT" ); 
      }
   }
}