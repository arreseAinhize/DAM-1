public class TestCircle4 {
    public static void main(String[] args) { // Program entry point
        // Declare and Construct an instance of the Circle class called c1
        Circle c1 = new Circle(2.0, "blue"); // Use 3rd constructor
        System.out.println(c1.toString()); // Circle[radius=3.0,color=blue]

        // Bucle for para cambiar el radio y el color en ciertos momentos
        for (int i = 1; i <= 10; i++) {
            c1.setRadius(c1.getRadius() + 1);
            // Seigarren iterazioan kolorea aldatzen da
            if (i == 6) {
                c1.setColor("magenta");
            }
            System.out.println(c1);
        }

    }
}
