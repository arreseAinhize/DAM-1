package paagbat.model;

import java.util.ArrayList;
import java.util.List;

import paagbat.model.base.Herria;
import paagbat.model.base.KostakoHerria;

/**
 * Herri desberdinen datuekin lan egiteko klasea
 */
public class HerrienZerak {

    private List<Herria> herrienZerrenda;

    /**
     * Herrien zerrenda hasieratzen du konstruktore honek.
     */
    public HerrienZerak() {
        // KostakoHerria klasea bukatuta daukazunean, lerroak ez-komentatu
        herrienZerrenda = new ArrayList<>();
        herrienZerrenda.add(new Herria("Ermua", "Bizkaia"));
        herrienZerrenda.add(new Herria("Eibar", "Gipuzkoa"));
        herrienZerrenda.add(new KostakoHerria("Deba", "Gipuzkoa", new String[] { "Santiago" }));
        herrienZerrenda.add(new KostakoHerria("Mutriku", "Gipuzkoa",
                new String[] { "Saturraran", "Alkolea", "Portukoa", "Ondarbeltz" }));
        herrienZerrenda
                .add(new KostakoHerria("Donostia", "Gipuzkoa", new String[] { "Ondarreta", "Kontxa", "Zurriola" }));

    }
    // ELEMENTU BERRI BAT GEHITZEKO
    public void add(Herria herria) {
        herrienZerrenda.add(herria);
    }
    /**
     * Getter normala.
     */
    public List<Herria> getHerrienZerrenda() {
        return herrienZerrenda;
    }

    /**
     * Herrien zerrendako herrien izenak bueltatzen ditu.
     */
    public List<String> getHerriIzenak() {
        // OSATU EZAZU
        List<String> herriIzenak = new ArrayList<>();
        for (Herria herria : getHerrienZerrenda()) {
            herriIzenak.add(herria.getHerriIzena());
        }
        return herriIzenak;
    }

    /**
     * Herrien zerrendako hondartza guztiak bueltatzen ditu.
     */
    public List<String> getHondartzaGuztiak() {
        // OSATU EZAZU
        List<String> hondartzaGuztiak = new ArrayList<>();

        for (Herria herria : getHerrienZerrenda()) {
            if(herria instanceof KostakoHerria ){         
                for (int i = 0; i < ((KostakoHerria)herria).getHondartzak().length; i++) {
                    hondartzaGuztiak.add(((KostakoHerria)herria).getHondartzak()[i]);
                }          
            }
        }
        return hondartzaGuztiak;
    }

    /**
     * Herria dagoeneko herrien zerrendan dagoen egiaztatzen du.
     * Izena egiaztatzea da nahikoa.
     */
    public boolean herriaBaDago(String herriIzena) {
        herriIzena.toLowerCase();
        for (int i = 0; i< getHerrienZerrenda().size(); i++) {
            if (getHerrienZerrenda().get(i).getHerriIzena().equalsIgnoreCase(herriIzena)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Herri bat ezabatzen du herrien zerrendatik.
     */
    public void herriaEzabatu(String herriIzena) {
        // OSATU EZAZU
        if (herriaBaDago(herriIzena)) {
            for (int i = herrienZerrenda.size() - 1; i >= 0; i--) {  // Alderantziz begiratu, elementuen indizea alda ez dadin
                if (herrienZerrenda.get(i).getHerriIzena().equals(herriIzena)) {
                    herrienZerrenda.remove(i);
                }
            }
        } else {
            System.out.println("Herri hori ez da listetan aurkitzen");
        }
    }
}