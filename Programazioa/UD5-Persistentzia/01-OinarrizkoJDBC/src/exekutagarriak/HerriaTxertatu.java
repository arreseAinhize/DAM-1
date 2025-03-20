package exekutagarriak;

import model.HerrienAtzipenak;
import model.base.Herria;
import java.util.Scanner;

/**
 * HerriaTxertatu klaseak herri berri bat datu-basean sartzeko aukera ematen du.
 * Erabiltzaileari herriaren izena eta probintzia eskatzen zaizkio, eta datuak
 * datu-basean gordetzen dira.
 */
public class HerriaTxertatu {

    /**
     * Programaren sarrera nagusia. Herri berri bat sartzen du datu-basean.
     * @throws Exception Konektibitate arazoak egonez gero.
     */
    public static void main(String[] args) throws Exception {
        HerrienAtzipenak herrienAtzipena = new HerrienAtzipenak("localhost", "HerrienDBa", "Herriak", "ikaslea", "ikaslea");
        Scanner in = new Scanner(System.in);

        // Datu-basearekin konexioa egiaztatzen du
        if (herrienAtzipena.konektatu() != null) {
            System.out.print("Sartu Herri izena: ");
            String HerriIzena = in.next();
            System.out.print("Sartu Herriaren probintzia: ");
            String HerriProbintzia = in.next();

            // Herri berria sortu eta datu-basean txertatu
            Herria herriBerria = new Herria(HerriIzena, HerriProbintzia);
            herrienAtzipena.txertatu(herriBerria);

            // Egiaztatzeko, datu-baseko datuak erakutsi
            herrienAtzipena.erakutsiDatuak();
        } else {
            System.out.println("Ez zara konektatua");
        }

        // Scanner-a itxi
        in.close();
    }
}
