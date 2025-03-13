package exekutagarriak;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import model.HerrienAtzipenak;

public class ProgramaKonplexuagoak {
    private static HerrienAtzipenak atzipenak = new HerrienAtzipenak("localhost", "HerrienDBa", "Herriak", "ikaslea", "ikaslea");
    private static Scanner in = new Scanner(System.in);

    /**
     * Erabiltzaileak ausazko herri bat eta bere probintzia erakusten ditu.
     * Erabiltzaileak probintzia zuzena adierazi behar du.
     */
    public static void ausazkoHerriEtaProbintzia() {
        List<String> herriak = atzipenak.getHerriIzenak();
        if (herriak.isEmpty()) {
            System.out.println("Ez dago herririk datu-basean.");
            return;
        }
        Random random = new Random();
        String herria = herriak.get(random.nextInt(herriak.size()));
        String probintzia = atzipenak.getProbintzia(herria);

        System.out.println("Ausazko herria: " + herria);
        System.out.print("Ze probintziakoa da? ");
        String userProbintzia = in.nextLine();

        if (userProbintzia.equalsIgnoreCase(probintzia)) {
            System.out.println("Zure erantzuna zuzena da!");
        } else {
            System.out.println("Okerreko erantzuna. Ezin izan da probintzia egokia aurkitu.");
        }
    }

    /**
     * Herrien txostentxoa sortzen du, probintzia bakoitzaren herriak 
     * eta kopurua erakutsiz.
     */
    public static void herrienTxostentxoa() {
        List<String> herriak = atzipenak.getHerriIzenak();
        List<String> probintziak = new ArrayList<>();

        // Herriak probintziaka taldekatzen ditugu
        for (String herria : herriak) {
            String probintzia = atzipenak.getProbintzia(herria);
            if (!probintziak.contains(probintzia)) {
                probintziak.add(probintzia);
            }
        }

        System.out.println("Herrien txostentxoa:");
        
        // Bakoitzaren probintziako herriak erakutsi
        for (String probintzia : probintziak) {
            List<String> herriakProbintzian = new ArrayList<>();
            for (String herria : herriak) {
                if (atzipenak.getProbintzia(herria).equals(probintzia)) {
                    herriakProbintzian.add(herria);
                }
            }

            System.out.println(probintzia + " probintzian dauden herriak (" + herriakProbintzian.size() + "):");
            for (String herria : herriakProbintzian) {
                System.out.println("- " + herria);
            }
        }
    }
}
