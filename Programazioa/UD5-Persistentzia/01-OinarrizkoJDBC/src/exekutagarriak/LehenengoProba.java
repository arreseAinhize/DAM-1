package exekutagarriak;
import model.HerrienAtzipenak;

public class LehenengoProba{
    public static void main(String[] args) throws Exception {
        HerrienAtzipenak herrienAtzipena = new HerrienAtzipenak("localhost","HerrienDBa","Herriak","ikaslea","ikaslea");

        if(herrienAtzipena.konektatu() != null){
            //System.out.println("konektatua");
            if(herrienAtzipena.kontsultatuKopurua() < 0){
                System.out.println("ERROR!");
            }
            else{
                System.out.println(herrienAtzipena.getTaula() + " taulako erregistro kopurua: " + herrienAtzipena.kontsultatuKopurua());
            }
            
        }else{
            System.out.println("Ez zara konektatua");
        }
    }
}
