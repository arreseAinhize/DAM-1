package herentziamembeabstraktobarik;

public class WaterMonster extends Monster {
    public WaterMonster(String name){
        super(name);
    }

    @Override
    public String attack(){
        return super.getName() + " uso salpicadura!";
    }
}
