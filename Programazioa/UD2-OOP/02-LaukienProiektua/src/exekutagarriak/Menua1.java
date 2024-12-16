package exekutagarriak;
import model.Laukia;
import java.util.Scanner;

public class Menua1 {
    private static int LAUKI_KOP = 10;
    private static int sortutakoak = 0;
    private static Laukia[] laukiak;
    public static Scanner in = new Scanner(System.in);
    

    public static void main(String[] args) {
        int aukera = 0;
        do{
            System.out.println("\nOngi etorri, Laukien proiektura!");
            System.out.println("==================================");
            System.out.println("1.- Lauki berri bat sortu\n2.- Laukien taula ikusi\n3.- Lauki bat marraztu\n4.- Lauki Handiena bilatu\n5.- Arraya automatikoki ausaz bete.\n6.- Irten\n");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();

            switch (aukera) {
                case 1:
                    if(sortutakoak == 10){
                        System.out.println("\nEzin dira lauki gehiago sortu.\n");
                    }else{
                        System.out.println("\nLAUKI BERRIA SORTZEN...");
                        sortu();
                    }
                    break;
                case 2:
                    imprimatu();
                    break;
                case 3:
                    marraztu();
                    break;
                case 4:
                    handiena();
                    break;
                case 5:
                    arrayaBete();
                    break;
                case 6:
                    System.out.println("\nEskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Ez dago balio horretako aukerarik, zahiatu berriro!");
                    break;
            }
        }while(aukera!=6);
    }
    
    public static void sortu(){
        laukiak = new Laukia[LAUKI_KOP];
        Laukia l1 = new Laukia(); //Lauki berria sortu
        System.out.print("Sartu laukiaren zabalera: ");
        l1.setZabalera(in.nextInt());
        System.out.print("Sartu laukiaren altuera: ");
        l1.setAltuera(in.nextInt());

        laukiak[sortutakoak++] = l1; //Laukiak "arrayan" sortu berri den laukia gorde
        System.out.println("Lauki " + l1.getMota() + " sortu duzu: => " + l1.toString());
    }

    public static void imprimatu(){
        if(sortutakoak == 0){
            System.out.println("\n Ez dago baliorik taulan \n");
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Laukia", "Zabalera", "Altuera", "Azalera", "Perimetroa", "Mota");
            System.out.println("==============================================================");
        }else{
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Laukia", "Zabalera", "Altuera", "Azalera", "Perimetroa", "Mota");
            System.out.println("==============================================================");
            // Bucle para mostrar los datos de cada lauki
            for (int i = 0; i < sortutakoak; i++) {
                System.out.printf("%-10d %-10d %-10d %-10d %-10d %-10s\n",i+1,laukiak[i].getZabalera(),laukiak[i].getAltuera(),laukiak[i].getAzalera(), laukiak[i].getPerimetroa(),laukiak[i].getMota());
            }
        }
    }

    public static void marraztu(){   
        if(sortutakoak ==0){
        // Errore mezua (ez badago laukirik sortuta ezingo da ezer marraztu)
            System.out.println("\nEz dago laukirik sortuta!\n");
        }else{
            System.out.print("\nZein lauki nahi duzu marraztu? (1-" + sortutakoak + ")");
            int index = in.nextInt() - 1;  // Laukiak "Array" barruan "nabegatzeko"
            if (index >= 0 && index < sortutakoak) { 
            // index 0 baina handiagoa ETA sortuta dauden lauki kopurua baino txikiagoa bada:
                System.out.print("Beteta/Hutsik/Pertsonalizatuta (B/H/P)? ");
                char ikurra = in.next().charAt(0); // Nola marraztu nahi da?
                if(ikurra == 'B' || ikurra == 'b'){
                // Beteta marraztu
                    laukiak[index].marraztuBeteta();
                }else if(ikurra == 'H' || ikurra == 'h'){
                // Hutzik marraztu
                    laukiak[index].marraztuHutzik();
                }else if(ikurra =='P' || ikurra =='p'){
                // Beteta marraztu ikur pertsonalizatuaz
                    System.out.print("Zein ikurrekin nahi duzu laukia bete? ");
                    laukiak[index].marraztuBeteta(in.next().charAt(0));
                }else{
                // Errore mezua
                    System.out.println("Ez da marrazteko era hori existitzen!");
                }
            } else {
            // Errore mezua
                System.out.println("Lauki zenbakia okerra."); 
            }
        }
    }

    public static void handiena(){
        if(sortutakoak == 0){
            System.out.println("\nEz dago laukirik sortuta.");
        }else{
            Laukia handiena = Laukia.getTheBiggest(laukiak);
            System.out.println("Hau da laukirik handiena: " + handiena.toString());
        }
    }

    public static void arrayaBete(){
        System.out.println("Arraya betetzeko laukiak sortzen...");

        laukiak = new Laukia[LAUKI_KOP];
        // Bucle para crear cada lauki
        for(int i = 0; i < LAUKI_KOP; i++) {
            laukiak[i] = new Laukia();

            laukiak[i].setZabalera((int)(Math.random() * 21)); //Num random del 0 al 20
            laukiak[i].setAltuera((int)(Math.random() * 21));//Num random del 0 al 20
        }
        sortutakoak = LAUKI_KOP;
    }

    
}