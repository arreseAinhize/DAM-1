/*
Write a method called print(), which takes an int array and print its contents in the form of [a1, a2, ..., an]. Take note that there is no comma after the last element. The method's signature is as follows:

public static void print(int[] array);
Also write a test driver to test this method (you should test on empty array, one-element array, and n-element array).

How to handle double[] or float[]? You need to write a overloaded version for double[] and a overloaded version for float[], with the following signatures:

public static void print(double[] array)
public static void print(float[] array)
The above is known as method overloading, where the same method name can have many versions, differentiated by its parameter list.
*/

package metodoak;

public class PrintArray {
    public static void intArry(int[] array){
        for (int i = 0; i < array.length; ++i) {
            if (i == 0) {
                if(array.length == 1){
                    System.out.println("["+array[0]+"]");
                }else{
                    System.out.print("["+array[0]);
                }
            }else if(i == array.length-1 ) {
                // Print the subsequent items with a leading commas
                System.out.println(", " + array[i]+"]");
            }else{
                System.out.print(", " + array[i]);
            }
        }
    }

    public static void floatArry(float[] array){
        for (int i = 0; i < array.length; ++i) {
            if (i == 0) {
                if(array.length == 1){
                    System.out.println("["+array[0]+"]");
                }else{
                    System.out.print("["+array[0]);
                }
            }else if(i == array.length-1 ) {
                // Print the subsequent items with a leading commas
                System.out.println(", " + array[i]+"]");
            }else{
                System.out.print(", " + array[i]);
            }
        }
    }

    public static void doubleArry(double[] array){
        for (int i = 0; i < array.length; ++i) {
            if (i == 0) {
                if(array.length == 1){
                    System.out.println("["+array[0]+"]");
                }else{
                    System.out.print("["+array[0]);
                }
            }else if(i == array.length-1 ) {
                // Print the subsequent items with a leading commas
                System.out.println(", " + array[i]+"]");
            }else{
                System.out.print(", " + array[i]);
            }
        }
    }
    public static void main(String[] args) {
        // Declare Arrays
        int[] intArryEmpt={};  
        int[] intArrySing={5};  
        int[] intArryMult={5,10,15,20,25};  

        float[] floatArryEmpt={};  
        float[] floatArrySing={3.3f};  
        float[] floatArryMult={3.3f,6.6f,9.9f,12.12f,15.15f}; 

        double[] doubleArryEmpt={};  
        double[] doubleArrySing={4.4};  
        double[] doubleArryMult={4.4,8.8,12.12,16.16,20.20}; 

        //PRINTs
        System.out.println("INT ARRYS");
        System.out.println("Empty array: ");
        intArry(intArryEmpt);
        System.out.print("One-element array: ");
        intArry(intArrySing);
        System.out.print("N-element array: ");
        intArry(intArryMult);

        System.out.println("FLOAT ARRYS");
        System.out.println("Empty array: ");
        floatArry(floatArryEmpt);
        System.out.print("One-element array: ");
        floatArry(floatArrySing);
        System.out.print("N-element array: ");
        floatArry(floatArryMult);

        System.out.println("Double ARRYS");
        System.out.println("Empty array: ");
        doubleArry(doubleArryEmpt);
        System.out.print("One-element array: ");
        doubleArry(doubleArrySing);
        System.out.print("N-element array: ");
        doubleArry(doubleArryMult);
    }
}
