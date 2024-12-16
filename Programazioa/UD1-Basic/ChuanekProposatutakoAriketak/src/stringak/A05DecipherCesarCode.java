package stringak;
import java.util.Scanner;

public class A05DecipherCesarCode {
    public static void main(String[] args) {
        String inStr;
        Scanner in = new Scanner(System.in);
        StringBuilder inNewStr = new StringBuilder();

        System.out.print("Enter a String: ");
        inStr = in.nextLine().toUpperCase();  // Leer toda la línea en mayúsculas
        in.close();

        for (int i = 0; i < inStr.length(); i++) {
            char inChar = inStr.charAt(i);  // Obtener el carácter en la posición i

            // Decifrar las letras de 'A' a 'Z'
            if (inChar >= 'D' && inChar <= 'Z') {
                inChar -= 3;  // Restar 3 para mover el carácter
            } else if (inChar == 'A') {
                inChar = 'X';  // Ajustar 'A'
            } else if (inChar == 'B') {
                inChar = 'Y';  // Ajustar 'B'
            } else if (inChar == 'C') {
                inChar = 'Z';  // Ajustar 'C'
            } 
            // Mantener los espacios y otros caracteres como están
            inNewStr.append(inChar);
        }

        System.out.println("Deciphered String: " + inNewStr);
    }
}
