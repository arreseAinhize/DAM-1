package herentziamembeabstraktobarik;

public class StoneMonster extends Monster{
    public StoneMonster(String name){ // Crear monsttuo de fuego
        super(name);
    }

    @Override // Sobre escribe el attack() default de Monster.java
    public String attack(){
        return "Attack with Stone stone";
    }
}
