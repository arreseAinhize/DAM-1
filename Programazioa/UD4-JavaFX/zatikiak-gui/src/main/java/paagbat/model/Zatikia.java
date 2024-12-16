package paagbat.model;
import java.util.Random;
public class Zatikia {
    // Atributuak: Zatikia definitzeko zenbakitzailea eta izendatzailea
    private int zenbakitzailea, izendatzailea;

    // Eraikitzaile lehenetsia (atributuak hasieratu gabe uzten dira)
    public Zatikia() {
        Random random= new Random();
        izendatzailea = random.nextInt(10)+1;
        zenbakitzailea = random.nextInt(10)+1;
        sinplificatu();
    }

    // Eraikitzaile bat: zenbakitzailea eta izendatzailea espezifikatzeko
    public Zatikia(int zenbakitzailea, int izendatzailea) {
        this.zenbakitzailea = zenbakitzailea;
        this.izendatzailea = izendatzailea;
    }

    // Eraikitzaile bat: zatikia string bezala jasotzen du (adibidez, "3/2")
    public Zatikia(String zatIdatzia) {
        String[] zat = zatIdatzia.split("/");
        
        zenbakitzailea = Integer.parseInt(zat[0]); // Zenbakitzailea gordetzen da
        izendatzailea = Integer.parseInt(zat[1]); // Izendatzailea gordetzen da
    }

    // Getter metodoa: zenbakitzailea itzultzen du
    public int getZenbakitzailea() {
        return zenbakitzailea;
    }

    // Getter metodoa: izendatzailea itzultzen du
    public int getIzendatzailea() {
        return izendatzailea;
    }

    // Setter metodoa: zenbakitzailea aldatzen du
    public void setZenbakitzaile(int zenba) {
        zenbakitzailea = zenba;
    }

    // Setter metodoa: izendatzailea aldatzen du
    public void setIzendatzaile(int izenda) {
        izendatzailea = izenda;
    }

    // Bi zatikiren biderkaketa egiten du eta emaitza itzultzen du
    public static Zatikia biderkatu(Zatikia zat1, Zatikia zat2) {
        int zenbaki = zat1.getZenbakitzailea() * zat2.zenbakitzailea;
        int izenda = zat1.getIzendatzailea() * zat2.izendatzailea;
        return new Zatikia(zenbaki, izenda);
    }

    public static Zatikia zatiketa(Zatikia zat1, Zatikia zat2) {
        int zenbaki = zat1.getZenbakitzailea() * zat2.izendatzailea;
        int izenda = zat1.getIzendatzailea() * zat2.zenbakitzailea;
        return new Zatikia(zenbaki, izenda);
    }

    // Bi zatikiren batuketa egiten du eta emaitza itzultzen du
    public static Zatikia batu(Zatikia zat1, Zatikia zat2) {
        int mkt = mkt(zat1.izendatzailea, zat2.izendatzailea); // Multiplo komun txikiena kalkulatzen du
        int zenbak = (zat1.zenbakitzailea * (mkt / zat1.izendatzailea))
                + (zat2.zenbakitzailea * (mkt / zat2.izendatzailea));
        return new Zatikia(zenbak, mkt);
    }

    public static Zatikia kendu(Zatikia zat1, Zatikia zat2) {
        int mkt = mkt(zat1.izendatzailea, zat2.izendatzailea); // Multiplo komun txikiena kalkulatzen du
        int zenbak = (zat1.zenbakitzailea * (mkt / zat1.izendatzailea))
                - (zat2.zenbakitzailea * (mkt / zat2.izendatzailea));
        return new Zatikia(zenbak, mkt);
    }

    // Zatikia beste batekin batzen du (objektuan bertan aldaketak egiten dira)
    public void batu(Zatikia besteZatBat) {
        Zatikia emaitza = batu(this, besteZatBat);
        zenbakitzailea = emaitza.zenbakitzailea;
        izendatzailea = emaitza.izendatzailea;
    }

    // Zatikia hamartar baliokidean bihurtzen du
    public double hamartarBaliokidea() {
        return (double) zenbakitzailea / izendatzailea;
    }

    // Zatikia sinplifikatzen du, zenbakitzailea eta izendatzailea zatiki
    // laburrenera eramanez
    public void sinplificatu() {
        int zkh = zkh(zenbakitzailea, izendatzailea); // Zatitzaile komun handiena
        zenbakitzailea /= zkh;
        izendatzailea /= zkh;
    }

    // Multiplo komun txikiena kalkulatzen du bi zenbakiren artean
    public static int mkt(int n1, int n2) {
        return (n1 * n2) / zkh(n1, n2);
    }

    // Zatitzaile komun handiena kalkulatzen du bi zenbakiren artean
    public static int zkh(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;        // 1. Guardamos el valor actual de n2 en una variable temporal.
            n2 = n1 % n2;         // 2. Calculamos el resto de dividir n1 entre n2 y lo asignamos a n2.
            n1 = temp;            // 3. Asignamos el valor anterior de n2 a n1.
        }
        return n1;                // 4. Cuando n2 es 0, n1 contiene el MCD.
    }
}
