package hasierakoak.oinarria;
public class Calculos2  {
    public static void main(String[] args) {
        double luzeera,zabalera,azalera,perimetroa;
        luzeera = 8.5;
        zabalera = 3.48;
        //Kalkuluak egiteko erabiliko ditugun ******
        azalera = luzeera * zabalera;
        perimetroa = (2 * luzeera) + (2 * zabalera);
        //Emaitzak
        System.out.println("Erabilitako Luzeera eta zabalera hauek dira: ");
        System.out.println("L: "+ luzeera + " Z: " + zabalera);
        System.out.println("Zirkunferentziaren azalera hau izango da: " + azalera );
        System.out.println("Zirkunferentziaren perimetroa hau izango da: " + perimetroa);
    }
}
