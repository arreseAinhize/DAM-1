import model.HerrienAtzipenak;

public class App {
    public static void main(String[] args) throws Exception {
        HerrienAtzipenak herrienAtzipena = new HerrienAtzipenak("localhost","HerrienDBa","Herriak","ikaslea","ikaslea");

        if(herrienAtzipena.Konektatu() != null){
        System.out.println("konektatua");
        }else{
        System.out.println("ez zara konektatua");
        }
    }
}
