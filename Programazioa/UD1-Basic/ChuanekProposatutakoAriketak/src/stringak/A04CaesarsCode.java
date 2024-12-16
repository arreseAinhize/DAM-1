package stringak;
import java.util.Scanner;

public class A04CaesarsCode {
    public static void main(String[] args) {
        String inStr;
        Scanner in = new Scanner(System.in);
        StringBuilder inNewStr = new StringBuilder();

        System.out.print("Enter a String: ");
        inStr = in.nextLine().toUpperCase();  // Leer toda la línea en mayúsculas
        in.close();

        for (int i = 0; i < inStr.length(); i++) {
            char inChar = inStr.charAt(i);  // Obtener el carácter en la posición i

            // Aplicar la lógica de cifrado César
            if (inChar >= 'A' && inChar <= 'W') {
                inChar += 3;  // Desplazar 3 posiciones
            } else if (inChar == 'X') {
                inChar = 'A';  // Ajustar para 'X'
            } else if (inChar == 'Y') {
                inChar = 'B';  // Ajustar para 'Y'
            } else if (inChar == 'Z') {
                inChar = 'C';  // Ajustar para 'Z'
            }else{
                System.out.println("ERROR");
            }

            // Añadir el carácter modificado (o sin cambios) a la nueva cadena
            inNewStr.append(inChar);
        }

        // Mostrar la cadena cifrada
        System.out.println("Ciphered String: " + inNewStr);
    }
}
