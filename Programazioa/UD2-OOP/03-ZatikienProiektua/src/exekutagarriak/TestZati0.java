package exekutagarriak;

import java.util.Scanner;

import model.Zatikia;

public class TestZati0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Sartu zatiki bi espazio batez bananduta eta nik handiena zein den esango dizut: ");
        String sarrera = in.nextLine();
        Zatikia zat1 =new Zatikia(sarrera);
        System.out.println(zat1.hamartarBaliokidea()); // <-- INFINITO
        System.out.println(6/0); // <-- ERROR
        in.close();
    }
}
