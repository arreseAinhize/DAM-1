package herentziamemberabstraktobarik;

public class FireMonster extends Monster {
    public FireMonster(String name) {
        super(name);
    
    }
    
    @Override
    public String attack(){
        return "Attack with (fuego fuego - Fire fire) ";
    }
}
