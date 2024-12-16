package hasierakoak.oinarria;
public class Loop4 { //SQUARE
    public static void main(String[] args){
        final int LOWERBOUND = 1;      // Store the lowerbound
        final int UPPERBOUND = 100;   // Store the upperbound
        int sum = 0; 

        //Bukleen hasiera
        int number = LOWERBOUND;

        //WHILE bukleak
        while (number <= UPPERBOUND) {
              // number = LOWERBOUND, LOWERBOUND+1, LOWERBOUND+2, ..., UPPERBOUND for each iteration
            sum = sum + (number * number);  // Accumulate number into sum
            ++number;
        }
        // Print the result
        System.out.println("The sum from " + LOWERBOUND + " to " + UPPERBOUND + " is " + sum);

    }
}
