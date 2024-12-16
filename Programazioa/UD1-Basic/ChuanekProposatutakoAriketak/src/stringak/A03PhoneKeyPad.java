package stringak;
import java.util.Scanner;

public class A03PhoneKeyPad {
    public static void main(String[] args) {
        String inStr;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a String: ");
        //inStr = in.next().toLowerCase(); <-- esaldiko lehenengo hitza bakarrik irakurriko du
        inStr = in.nextLine().toLowerCase(); //<-- esaldi osoa irakurriko du.
        in.close();
        for(int i=0; i< inStr.length(); i++ ){
            char inChar = inStr.charAt(i);  // Obtener el carácter en la posición i
            switch (inChar) {  // Cambiar con el carácter, no con la cadena completa
                case 'a': case 'b': case 'c':  // No break for 'a' and 'b', fall through 'c'
                    if(inChar == 'a'){
                        System.out.print(2);
                    }else if(inChar =='b'){
                        System.out.print(22);
                    }else{
                        System.out.print(222);
                    }
                    break;
                case 'd': case 'e': case 'f':
                    if(inChar == 'd'){
                        System.out.print(3);
                    }else if(inChar =='e'){
                        System.out.print(33);
                    }else{
                        System.out.print(333);
                    }
                    break;
                case 'g': case 'h': case 'i':
                    if(inChar == 'g'){
                        System.out.print(4);
                    }else if(inChar =='h'){
                        System.out.print(44);
                    }else{
                        System.out.print(444);
                    }
                    break;
                case 'j': case 'k': case 'l':
                    if(inChar == 'j'){
                        System.out.print(5);
                    }else if(inChar =='k'){
                        System.out.print(55);
                    }else{
                        System.out.print(555);
                    }
                    break;
                case 'm': case 'n': case 'o':
                    if(inChar == 'm'){
                        System.out.print(6);
                    }else if(inChar =='n'){
                        System.out.print(66);
                    }else{
                        System.out.print(666);
                    }
                    break;
                case 'p': case 'q': case 'r': case 's':
                    if(inChar == 'p'){
                        System.out.print(7);
                    }else if(inChar =='q'){
                        System.out.print(77);
                    }else if(inChar =='r'){
                        System.out.print(777);
                    }else{
                        System.out.print(7777);
                    }
                    break;
                case 't': case 'u': case 'v':
                    if(inChar == 't'){
                        System.out.print(8);
                    }else if(inChar =='u'){
                        System.out.print(88);
                    }else{
                        System.out.print(888);
                    }
                    break;
                case 'w': case 'x': case 'y': case 'z':
                    if(inChar == 'w'){
                        System.out.print(9);
                    }else if(inChar =='x'){
                        System.out.print(99);
                    }else if(inChar =='y'){
                        System.out.print(999);
                    }else{
                        System.out.print(9999);
                    }
                    break;
                case ' ':
                    System.out.print(0);                   
                    break;
                default:
                    System.out.println("El caracter introducido no se encuentra en el KeyPad.");
                    break;
            }
        }
    }
}
