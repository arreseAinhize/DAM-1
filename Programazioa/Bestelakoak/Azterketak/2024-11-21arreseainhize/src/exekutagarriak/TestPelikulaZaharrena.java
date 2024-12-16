package exekutagarriak;
import model.Pelikula;

public class TestPelikulaZaharrena {
    /**
     *    Metodo honek ahurretik sorturik dagoen pelikula zerrenda bat bistaratuko du
     *  eta zerrenda horretako pelikulen estrenaildi urtea kontuan izanda pelikula
     *  zaharrena zein den bistaratuko ido erabiltzaileari.
     */
    public static void main(String[] args) {
        System.out.println("PELIKULEN ZERRENDA");
        System.out.println("==================");
        Pelikula p1 = new Pelikula(); 
        p1.setIzenburua("Cadena Perpetua");
        p1.setUrtea(1994);
        p1.setIraupena(0);
        Pelikula p2 = new Pelikula();
        p2.setIzenburua("El Padrino");
        p2.setUrtea(1972);
        p2.setIraupena(0);
        Pelikula p3 = new Pelikula(); 
        p3.setIzenburua("El caballero oscuro");
        p3.setUrtea(2008);
        p3.setIraupena(0);


        Pelikula[] pelikulak = {p1,p2,p3};
        System.out.println("1. "+p1.toString());
        System.out.println("2. "+p2.toString());
        System.out.println("3. "+p3.toString());

        // ZUZENAGOA:
        // for(int i = 0; i<pelikulak.length;i++){
        //     System.out.println("1. "+pelikulak[i].toString());
        // }

        Pelikula zaharrena = Pelikula.zaharrena(pelikulak);
        System.out.println("Zerrendako pelikularik zaharrena: " + zaharrena.toString());
    }
}
