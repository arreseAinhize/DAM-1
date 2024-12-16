package model;
import java.util.Random; // Zenbaki aleatorioak sortuko ditu

public class Laukia {
    private int zabalera =  5;
    private int altuera = 5;

    public Laukia() {
    }

    public Laukia(int zab, int alt) {
        zabalera = zab;
        altuera = alt;
    }

    public int getZabalera() {
        return zabalera;
    }

    public int getAltuera() {
        return altuera;
    }

    public int getAzalera() {
        return zabalera * altuera;
    }

    public int getPerimetroa() {
        return (zabalera * 2) + (altuera * 2);
    }

    public void setZabalera(int zabaleraBerria) {
        zabalera = zabaleraBerria;
    }

    public void setAltuera(int altueraBerria) {
        altuera = altueraBerria;
    }

    public String toString() {
        return "Laukia[" + zabalera + "x" + altuera + "]";
    }

    public String getMota() {
        if (zabalera > altuera) {
            return "Horizontala";
        } else if (zabalera < altuera) {
            return "Bertikala";
        } else {
            return "Karratua";
        }
    }

    public void marraztuBeteta() {
        for (int col = 1; col <= altuera; col++) {
            for (int row = 1; row <= zabalera; row++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void marraztuBeteta(char ikurra) {
        for (int col = 1; col <= altuera; col++) {
            for (int row = 1; row <= zabalera; row++) {
                System.out.print(ikurra + " ");
            }
            System.out.println();
        }
    }

    public void marraztuHutzik() {
        for (int col = 1; col <= altuera; col++) {
            for (int row = 1; row <= zabalera; row++) {
                if ((row == 1 || row == zabalera || col == 1 || col == altuera)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public String laukiBetea() {
        StringBuilder laukiBetea = new StringBuilder();
        for (int col = 1; col <= altuera; col++) {
            for (int row = 1; row <= zabalera; row++) {
                laukiBetea.append("* ");
            }
            laukiBetea.append("\n");
        }
        return laukiBetea.toString();
    }

    public void handitu(double portzentai) {
        double altuera = getAltuera();
        double zabalera = getZabalera();

        zabalera = (portzentai * zabalera)/ zabalera;
        altuera = (portzentai * altuera)/altuera;
    }

    public boolean isBiggerThan(Laukia l) {
        return getAzalera() > l.getAzalera(); //lk[i] eta handiena konparatuko ditu.
    }

    public static Laukia getTheBiggest(Laukia[] lk) {
        if(lk == null || lk.length ==0){
            return null; //Lk no tiene valor alguno esta mas vacio que mis ganas de vivir :>
        }

        Laukia handiena = lk[0];
        
        for (int i = 1; i < lk.length; i++) {
            if (lk[i] != null && lk[i].isBiggerThan(handiena)) { 
            // lk[i] ez bada null ETA handiena baino handiagoa bada:
                handiena = lk[i]; // Handienari balio berria heman.
            }
        }
        return handiena;
        //For-ak array guztia pasa ostean, eta konparazio guztiak egun ostean dagoen bali¡ore andiena aterako du.
    }

    public static void ordenatu (Laukia[] laukiak){
        
    }
}
