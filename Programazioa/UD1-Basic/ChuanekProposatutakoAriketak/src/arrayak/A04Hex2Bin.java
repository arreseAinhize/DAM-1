package arrayak;
import java.util.Scanner;

public class A04Hex2Bin {
    public static void main(String[] args) {
        final String[] BIN_STRS = {"0000", "0001", "0010", "0011",
                                    "0100", "0101", "0110", "0111",
                                    "1000", "1001", "1010", "1011",
                                    "1100", "1101", "1110", "1111"};
        String hexStr;     // The input hexadecimal String
        int hexStrLen;     // The length of hexStr
        char hexChar;      // Each char in the hexStr
        String binStr =""; // The equivalent binary String, to accumulate from an empty String
        // Lookup table for the binary sub-string corresponding to Hex digit '0' (index 0) to 'F' (index 15)
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Hexadecimal string: ");
        hexStr = in.next().toUpperCase();
        hexStrLen = hexStr.length();
        in.close();

        // Process the string from the left (most-significant hex digit)
        for (int charIdx = 0; charIdx < hexStrLen; ++charIdx) {
            hexChar = hexStr.charAt(charIdx);
            if (hexChar >= '0' && hexChar <= '9') {
            binStr += BIN_STRS[hexChar - '0'] + " ";  // index into the BIN_STRS array and concatenate
            } else if (hexChar >= 'A' && hexChar <= 'F') {
            binStr += BIN_STRS[hexChar - 'A' + 10] +" ";
            } else {
            System.err.println("error: invalid hex string \"" + hexStr + "\"");
            return;   // or System.exit(1);
            }
        }
        System.out.println("The equivalent binary for: " + hexStr + "\nIs: "+ binStr);
    }
}
