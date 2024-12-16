package stringak;

public class galdera01 {
    public static void main(String[] args) {
        int batuketa = 0;
        String hitza = "amama";
        char hizkia = 'a';
        for (int i=0;i<hitza.length();i++){
            if (hitza.charAt(i) == hizkia) {
                batuketa++;
            }    
        }
        System.out.println(batuketa);
    }
}
//EMAITZA = 3