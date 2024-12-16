package metodoak;

import java.util.Scanner;

public class Odd {
    public static void main(String[] args) {
        int number;
        Scanner in = new Scanner(System.in);

        System.err.println("Enter the number: ");
        number = in.nextInt();
        isOdd(number);
        in.close();
        if (isOdd(number) == false) {
            System.out.println(number + " is an odd number"); //IMPAR
        }else if(isOdd(number) == true){
            System.out.println(number + " is an even number"); //PAR
        }else{
            System.out.println("Error!");
        }
        
    }
    public static boolean isOdd(int number){
        boolean isOdd = false; //dafeult Impar
        if(number%2==0){
            isOdd = true; //Par
        }
        return isOdd;
    }

}
