package hasierakoak.oinarria;
/*
 * print all the leap years between AD999 and AD2010. Also print the total number of leap years. (Hints: use a int variable called count, which is initialized to zero. Increment the count whenever a leap year is found.)
 */
public class Condicional2 {
    public static void main (String[] args){ //psvm + tab 
        int sum = 0;
        final int LOWERBOUND = 999;
        final int UPPERBOUND = 2010;
        for (int i = LOWERBOUND; i <= UPPERBOUND; i++) { // hace un bucle hasta al 2010 desde 999
            if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)) { //Seleccionar los años visiestos
                ++sum;
                System.out.println(i);
            }
        }
        System.out.println("Total de años visiestos: " + sum); //sout + tab 
    }
}
