package hasierakoak.oinarria;
public class Loop {
    public static void main(String[] args){
        final int LOWERBOUND = 1;      // Store the lowerbound
        final int UPPERBOUND = 1000;   // Store the upperbound
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
        int suma = 0;
        do{
            suma = suma + number;  // Accumulate number into sum
            ++number;            // increment number
        }
        while (number <= UPPERBOUND);
        // Print the result
        System.out.println("The sum from " + LOWERBOUND + " to " + UPPERBOUND + " is " + sum);

        //FOR bukleak
        int gehiketa = 0;
        final int limInf = 1;
        final int limSup = 1000;

        int numero = limInf;
        for(int i = 0; i < limSup; i++){
            gehiketa = gehiketa + numero;  // Accumulate number into sum
            ++numero;
        }
        System.out.println("La suma total desde " + limInf + " hasta el "+ limSup +" es: " + gehiketa);
    }
}
