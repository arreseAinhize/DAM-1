package exekutagarriak;

import java.util.Scanner;

import model.Zatikia;

public class TestSalbuespena {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Sartu zatiki bat: ");
        String sarrera = in.nextLine();
        isNumeric(sarrera);
        if(isNumeric(sarrera) == true){
            Zatikia zat = new Zatikia(sarrera);
            System.out.println(zat.toString());
        }else{
            System.out.println("Zenbaki bat sartu behar duzu X/Y formatuan!" );
        }
        in.close();
    }
    public static boolean isNumeric(String cadenaString) {
        String[] cadena = cadenaString.split("/");
        try {
            Integer.parseInt(cadena[0]);
            Integer.parseInt(cadena[1]);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
