package paagbat.model;

import paagbat.model.base.Herria;
import paagbat.model.base.KostakoHerria;

/** Klase hau HerrienZerak klasea ondo programatzen zabiltzan jakiteko erabili
 */
public class TestHerrienZerak {
    // Eskuineko komentarioetan dauzkazu ikusi beharreko emaitzak.
    // Ez-komentatu lerroak metodoak programatzen dituzun neurrian
    public static void main(String[] args) {
        
        HerrienZerak herrienZerak = new HerrienZerak();
        System.out.println("Herri izenak: "+herrienZerak.getHerriIzenak());//[Ermua, Eibar, Deba, Mutriku, Donostia]
        System.out.println("Herrien zerrenda: "+herrienZerak.getHerrienZerrenda());//[Ermua (Bizkaia), Eibar (Gipuzkoa), Deba (Gipuzkoa), Mutriku (Gipuzkoa), Donostia (Gipuzkoa)]
        System.out.println("Hondartza guztiak: "+ herrienZerak.getHondartzaGuztiak());//[Santiago, Saturraran, Alkolea, Portukoa, Ondarbeltz, Ondarreta, Kontxa, Zurriola]
        System.out.println("Eibar al dago? "+herrienZerak.herriaBaDago("Eibar"));//true
        System.out.println("Ondarroa al dago? "+herrienZerak.herriaBaDago("Ondarroa"));//false
        herrienZerak.herriaEzabatu("Donostia");
        System.out.println("Herrien zerrenda eguneratua: "+herrienZerak.getHerrienZerrenda());//[Ermua (Bizkaia), Eibar (Gipuzkoa), Deba (Gipuzkoa), Mutriku (Gipuzkoa)]);
        System.out.println("Txosten konpletoagoa:");
        for (Herria herria : herrienZerak.getHerrienZerrenda()) {
            System.out.print("- ");
            if (herria instanceof KostakoHerria) {
                System.out.println(((KostakoHerria)herria).toStringKonpletoagoa());
            } else {
                System.out.println(herria);
            }
        }
        /**  (nola ikusi behar den)
            Txosten konpletoagoa:
            - Ermua (Bizkaia)
            - Eibar (Gipuzkoa)
            - Deba (Gipuzkoa)
                Santiago
            - Mutriku (Gipuzkoa)
                Saturraran
                Alkolea
                Portukoa
                Ondarbeltz
         */
        
    }
}
