package hasierakoak.oinarria;
public class Loop1 {
    public static void main(String[] args){
        final int LOWERBOUND = 9;      // Store the lowerbound
        final int UPPERBOUND = 899;   // Store the upperbound
        int sum = 0; 

        //Bukleen hasiera
        int number = LOWERBOUND;

        //WHILE bukleak
        while (number <= UPPERBOUND) {
              // number = LOWERBOUND, LOWERBOUND+1, LOWERBOUND+2, ..., UPPERBOUND for each iteration
           sum = sum + number;  // Accumulate number into sum
           ++number;            // increment number
        }
        // Print the result
        System.out.println("The sum from " + LOWERBOUND + " to " + UPPERBOUND + " is " + sum);

        //DO.. WHILE bukleak
    }
}
