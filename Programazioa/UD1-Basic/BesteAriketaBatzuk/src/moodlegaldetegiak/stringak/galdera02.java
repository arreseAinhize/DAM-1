package stringak;

public class galdera02 {
    public static void main(String[] args) {
        String hitz1 = "bat";
        String hitz2 = "uno";
        String hitz3 = "one";
        if (!hitz1.equals(hitz2)) {
            if (!hitz1.equals(hitz3)) {
                if (!hitz2.equals(hitz3)) {
                    System.out.println("a");
                } else {
                    System.out.println("b");
                }
            } else {
                System.out.println("c");
            }
        } else {
            System.out.println("d");
        }
    }
}
//EMAITZA = a