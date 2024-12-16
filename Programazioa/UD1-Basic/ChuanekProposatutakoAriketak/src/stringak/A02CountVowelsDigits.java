package stringak;

/*
 * Write a program called CountVowelsDigits, which prompts the user for a String, counts the number of vowels (a, e, i, o, u, A, E, I, O, U) and digits (0-9) contained in the string, and prints the counts and the percentages (rounded to 2 decimal places).  For example,
  *  Enter a String: testing12345
  *  Number of vowels: 2 (16.67%)
  *  Number of digits: 5 (41.67%)
 */

import java.util.Scanner;

public class A02CountVowelsDigits {
    public static void main(String[] args) {
        // Define variables
        String inStr;        // input String
        float inStrVowel=0,inStrDigits=0,inSrLength,finalVowel,fianlDigits;        // length of the input String
        char inChar;

        //......
        Scanner in = new Scanner(System.in);

        // Prompt and read input as "String"
        System.out.print("Enter a String: ");
        inStr = in.next().toLowerCase();   // use next() to read a String <-- .tolowerCase() = pasa todas las letras a minuscula.
        //inStrLen = inStr.length();
        for (int idx = 0; idx < inStr.length(); ++idx) {
            inChar = inStr.charAt(idx);
            // Do something about the extracted char
            if(Character.isDigit(inChar)){
                inStrDigits ++;
            }else if(inChar == 'a' ||inChar == 'e' ||inChar == 'i' ||inChar == 'o' || inChar=='u'){
                inStrVowel ++;
            }else{
                System.err.println("ERROR!");
            }
        }
        inSrLength = inStr.length();
        finalVowel= (inStrVowel/inSrLength)*100; // Calcula el % de vocales en el string
        fianlDigits= (inStrDigits/inSrLength)*100; // Calcula el % de digitos en el String
        System.out.printf("Number of vowels: %.0f (%.2f%%)\n",inStrVowel,finalVowel); // salto de linea = \n
        System.out.printf("Number of digits: %.0f (%.2f%%)",inStrDigits,fianlDigits); // %.0f --> 0 decimales, %.2f --> 2 decimales...

        in.close();
    }
}
