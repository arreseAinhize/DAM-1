package baldintzaerrepikapenak;

public class Galdera8 {
    public static void main(String[] args) {
        int a = 1;
        while (a <= 10) {
            if (a % 2 == 0) {
                System.out.print("M");
            }
            a++;
        }
    }
}

/*
    * EMAITZA:
        * MMMMM
        *(2,4,6,8,10) <-- kasuetan if-a beteko da, hondarra 0 dealako.
 */