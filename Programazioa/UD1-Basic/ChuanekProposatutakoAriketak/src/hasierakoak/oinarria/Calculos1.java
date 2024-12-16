package hasierakoak.oinarria;
/*
 * Programa honek, zirkunferentzia baten azalera eta perimetroa kalkulatzen du.
 */

public class Calculos1 {
    public static void main(String[] args){
        double radio,azalera,perimetroa;
        final double PI = 3.14159265; // PI variablearen balioa ezin da aldatu, beti berdina da (hori adierazteko "final" erabiltzen dugu.)
        radio = 3.5;
        //Kalkuluak egiteko erabiliko ditugun ******
        azalera = radio * radio * PI;
        perimetroa = 2 * PI * radio;
        //Emaitzak
        System.out.println("Erabilitako erradioa hau da: " + radio);
        System.out.println("Zirkunferentziaren azalera hau izango da: " + azalera );
        System.out.println("Zirkunferentziaren perimetroa hau izango da: " + perimetroa);
    }
}
