package hasierakoak.oinarria;
public class Calculos3 {
    public static void main(String[] args) {
        double altuera,radioa,azalera,bolumena;
        final double PI = 3.14159265;

        altuera = 4.9;
        radioa = 3.6;

        azalera = 2 * PI * radioa * (altuera + radioa);
        bolumena = PI * radioa * radioa * altuera; 

        System.out.print("Erabilitako erradioa hau da: " + radioa);
        System.out.println("eta erabilitako altuera hau: " + altuera);
        System.out.println("Beraz zirkunferentziaren bolumena hau izango da: " + bolumena );
        System.out.println("Eta zirkunferentziaren azalera hau: " + azalera);
    }
}
