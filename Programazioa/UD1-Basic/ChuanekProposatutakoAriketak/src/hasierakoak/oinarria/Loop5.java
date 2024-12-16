package hasierakoak.oinarria;
public class Loop5 { //SQUARE
    public static void main(String[] args){
        final int LOWERBOUND = 1;      // Store the lowerbound
        final int UPPERBOUND = 10;   // Store the upperbound
        long product = 1; // Declare a long variable "product" to avoid overflow
        // Set the initial product to 1

        //Bukleen hasiera
        int number = LOWERBOUND;

        //WHILE bukleak
        while (number <= UPPERBOUND) {
              // number = LOWERBOUND, LOWERBOUND+1, LOWERBOUND+2, ..., UPPERBOUND for each iteration
            product = product * number;  // Accumulate number into sum
            ++number;
        }
        // Print the result
        System.out.println("The sum from " + LOWERBOUND + " to " + UPPERBOUND + " is " + product);

    }
}
