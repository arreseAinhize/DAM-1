package moodlegaldetegiak.arrayak;
// Zer falta da parentesien barruan hurrengoa inprimatzea nahi badugu?

// Astelehena
// Asteartea
// Asteazkena
// Osteguna
// Ostirala
// Larunbata
// Igandea
public interface Galdera4 {
    public static void main(String[] args) {
        String[] astekoEgunak = {"Astelehena", "Asteartea", "Asteazkena", "Osteguna", "Ostirala", "Larunbata", "Igandea"};
        for (String eguna:astekoEgunak) {
            System.out.println(eguna);
        }
    }
}


//Nire erantzuna: int i = 0 ; i < astekoEgunak.length; i++

//Berak For-each bat nahi zeban..... --> String eguna:astekoEgunak