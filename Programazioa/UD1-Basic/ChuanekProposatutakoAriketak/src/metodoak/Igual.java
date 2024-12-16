package metodoak;

public class Igual {
    public static void main(String[] args) {
        int[] array1 ={2,5,6,7};
        int[] array2 ={2,5,7,8};

        System.out.println("Are the two array's the same? " + equals(array1, array2));
    }
    
    public static boolean equals(int[] array1, int[] array2){
        if (array1.length != array2.length) {
            return false;
        }
    
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false; 
            }
        }
    
        return true; 
    }
}
