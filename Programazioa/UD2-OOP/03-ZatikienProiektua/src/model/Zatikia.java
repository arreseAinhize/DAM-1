package model;
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

    // Zatikia string formatuan itzultzen du (adibidez, "3/2")
    public String toString() {
        return zenbakitzailea + "/" + izendatzailea;
    }

    // Bi zatikiren biderkaketa egiten du eta emaitza itzultzen du
    public static Zatikia biderkatu(Zatikia zat1, Zatikia zat2) {
        int zenbaki = zat1.getZenbakitzailea() * zat2.zenbakitzailea;
        int izenda = zat1.getIzendatzailea() * zat2.izendatzailea;
        return new Zatikia(zenbaki, izenda);
    }

    // Bi zatikiren batuketa egiten du eta emaitza itzultzen du
    public static Zatikia batu(Zatikia zat1, Zatikia zat2) {
        int mkt = mkt(zat1.izendatzailea, zat2.izendatzailea); // Multiplo komun txikiena kalkulatzen du
        int zenbak = (zat1.zenbakitzailea * (mkt / zat1.izendatzailea))
                + (zat2.zenbakitzailea * (mkt / zat2.izendatzailea));
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

    // Zatikia beste batekin baliokidea den konprobatzen du
    public boolean isBaliokidea(Zatikia besteZatikiBat) {
        return zenbakitzailea * besteZatikiBat.izendatzailea == izendatzailea * besteZatikiBat.zenbakitzailea;
    }

    // Konparaketa: zatikia beste bat baino handiagoa den konprobatzen du
    public boolean isBiggerThan(Zatikia besteZatikiBat) {
        return this.hamartarBaliokidea() > besteZatikiBat.hamartarBaliokidea();
    }

    // Zatikia sinplifikatzen du, zenbakitzailea eta izendatzailea zatiki
    // laburrenera eramanez
    public void sinplificatu() {
        int zkh = zkh(zenbakitzailea, izendatzailea); // Zatitzaile komun handiena
        zenbakitzailea /= zkh;
        izendatzailea /= zkh;
    }

    // Zenbaki baten faktorizazioa egiten du eta emaitza array batean itzultzen du
    public static int[] faktorizatu(int n) {
        if (n < 0) {
            System.out.println("Zenbaki negatiboen faktoriala ezin da kalkulatu.");
        }

        int[] emaitzak = new int[n + 1]; // Faktorialen emaitzak gordetzeko array-a
        emaitzak[0] = 1; // 0! = 1 lehenetsia

        for (int i = 1; i <= n; i++) {
            emaitzak[i] = emaitzak[i- 1] * i; // i! = (i-1)! * i
        } 

        return emaitzak;
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

    // Zatikien array bat ordenatzen du (handienetik txikienera edo txikienetik
    // handienera)
    public static void zatikiaOrdenatu(Zatikia[] zatikiaArray,boolean handienetikTxikienera ) {
        int n = zatikiaArray.length;
        
        // Burbuila-ordenaketa algoritmoa
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((handienetikTxikienera && zatikiaArray[j].hamartarBaliokidea() < zatikiaArray[j + 1].hamartarBaliokidea()) ||
                (!handienetikTxikienera && zatikiaArray[j].hamartarBaliokidea() > zatikiaArray[j + 1].hamartarBaliokidea())) {
                    Zatikia temp = zatikiaArray[j];
                    zatikiaArray[j] = zatikiaArray[j + 1];
                    zatikiaArray[j + 1] = temp;
                }
            }
        }
    }
}
