package herentziamembeabstraktobarik;

public class FireMonster extends Monster{ // Herencia de Monster
    public FireMonster(String name){ // Crear monsttuo de fuego
        super(name);
    }

    @Override // Sobre escribe el attack() default de Monster.java
    public String attack(){
        return "Attack with fire (fuego fuego - fire fire) ";
    }
}
