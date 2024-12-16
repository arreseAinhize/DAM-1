package arrayak;
import java.util.Scanner;

    public class A05Dec2Hex {
        public static void main(String[] args) {
            // Declare variables
        int dec;              // The input decimal number in "int"
        String hexStr = "";   // The equivalent hex String, to accumulate from an empty String
        int radix = 16;       // Hex radix
        final char[] HEX_CHARS =     // Use this array as lookup table for converting 0-15 to 0-9A-F
            {'0','1','2','3', '4','5','6','7', '8','9','A','B', 'C','D','E','F'};
    
        // Prompt and read input as "int"
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        dec = in.nextInt();
        in.close();
    
        // Repeated modulus/division and get the hex digits (0-15) in reverse order
        for(int i = 0; i<dec;i++){
            int hexDigit = dec % radix;   // 0-15
            hexStr = HEX_CHARS[hexDigit] + hexStr;  // Append in front of the hex string corresponds to reverse order
            dec = dec / radix;
        }
        System.out.println("The equivalent hexadecimal number is " + hexStr);
        }
    }
