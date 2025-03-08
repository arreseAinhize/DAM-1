package paagbat.model.base;

public class KostakoHerria extends Herria{
    private String[] hondartzak;

    public KostakoHerria(String izena, String probintzia, String[] hondartzak){
        super(izena, probintzia);
        this.hondartzak = hondartzak;
    }

    public String[] getHondartzak(){
        return hondartzak;
    }

    public String toStringKonpletoagoa(){
        String textua = super.getHerriIzena() + " (" + super.getProbintzia() + ")\n";
        for (int i = 0; i < getHondartzak().length; i++) {
            textua += getHondartzak()[i] + "\n";
        } 
        return textua;
    }

}
