package exekutagarriak;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TestSelekzioa {
    public static void main(String[] args) {
        Selekzioa euskalSel = new Selekzioa("Euskadi");
        Scanner in = new Scanner(System.in);

        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUA");
            System.out.println("====================================");
            System.out.println("*  1. Kideen datuak ikusi");
            System.out.println("*  2. Kideen datuak ikusi taldekatuta");
            System.out.println("*  3. Kideak alfabetikoki inprimatu");
            System.out.println("*  4. Aldatu kidearen izena");
            System.out.println("*  5. Bilatu abizenetik");
            System.out.println("*  6. Futbolariak alfabetikoki inprimatu");
            System.out.println("*  7. Irten\n");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    System.out.println("====================================");
                    euskalSel.kideakBistaratu();
                    break;
                case 2:
                    System.out.println("====================================");
                    euskalSel.kideakTaldekatutaBistaratu();
                    break;
                case 3:
                    System.out.println("====================================");
                    ArrayList<Kidea> kideak = euskalSel.getKideak();
                    kideak.sort((k1, k2) -> k1.getIzena().compareTo(k2.getIzena()));
                    //bi kideen arteko konparazio "compareTo" metodoaren bidez.
                    for (Kidea k : kideak) {
                        System.out.println(k);
                    }
                    break;
                case 4:
                    System.out.println("====================================");
                    String idletra;
                    boolean idZenbakia = false;
                    System.out.println("Sartu kidearen ID-a aldatu nahi duzun:");
                    idletra = in.next();
                    while(!idZenbakia){
                        try{
                            Integer.parseInt(idletra);
                            idZenbakia = true;
                        }catch(NumberFormatException e){
                            idZenbakia = false;
                            System.out.println("Sartu kidearen ID-a aldatu nahi duzun:");
                            idletra = in.next(); 
                        }
                    }
                    int id = Integer.parseInt(idletra);
                    Kidea kide = null;

                    for (Kidea k : euskalSel.getKideak()) { //euskalSel-en kidea bilatu
                        if (k.getId() == id) {
                            kide = k; // kidea aukituta "kide"-n gorde
                            break;
                        }
                    }

                    if (kide != null) {
                        String izenZaharra = kide.getIzena();
                        System.out.println("Sartu izena:"); 
                        String izena = in.next();
                        kide.setIzena(izena);
                        System.out.println("Aldaketa ondo egin da.\n Izen zaharra: "+izenZaharra+" / Izen berria: " + kide.getIzena());
                    } else {
                        System.out.println("ID hori ez da aurkitu."); 
                    }
                    break; 

                case 5:
                    System.out.println("====================================");
                    System.out.println("Sartu abizena:");
                    String abizena = in.next();
                    boolean aurkituDa = false;
                    for (Kidea k : euskalSel.getKideak()) {
                        if (k.getAbizena().equalsIgnoreCase(abizena)) {
                            System.out.println(k);
                            aurkituDa = true;
                        }
                    }
                    if (!aurkituDa) {
                        System.out.println("Ez da kiderik aurkitu abizena horrekin: " + abizena);
                    }
                    break;
                case 6:
                    System.out.println("====================================");
                    ArrayList<Kidea> futbolariak = new ArrayList<>();
                    for (Kidea k : euskalSel.getKideak()) {
                        if (k instanceof Futbolaria) { //Kidea futbolaria den begiratu
                            futbolariak.add(k);
                        }
                    }


                    futbolariak.sort((f1, f2) -> f1.getIzena().compareTo(f2.getIzena()));
                    //bi kideen arteko konparazio "compareTo" metodoaren bidez.
                    for (Kidea f : futbolariak) {
                        System.out.println(f);
                    }
                    break;

                    /*
                     *  kideak.sort((f1, f2) -> f1.getIzena().compareTo(f2.getIzena()));
                     *  for(int i = 0; i <= kideak.size() ; i++){
                     *      Kidea kide = kideak.get(i);
                     *      if(i instanceof Furbolaria){
                     *          System.out.println(kide);
                     *      }
                     *  }
                     */
                
                case 7:
                    System.out.println("====================================");
                    System.out.println("Programatik irten zara.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }

        } while (aukera != 7);
        in.close();
    }
}
