package baldintzaerrepikapenak;

public class Galdera7 {
    public static void main(String[] args) {
        int gogoa = 0;
        String eguna = "ostirala";
        switch (eguna) {
            case "astelehena":
                gogoa--;
            case "asteartea":
                gogoa--;
            case "asteazkena":
                gogoa--;
            case "osteguna":
                gogoa--;
            case "ostirala":
                gogoa++;
            case "larunbata":
                gogoa = gogoa * 2;
            default:
                gogoa = 0;
        }
    }
}

/*
    * EMAITZA:
        * gogoa = 0
        * casu bakoitzaren ostean "break;" falta da.
 */