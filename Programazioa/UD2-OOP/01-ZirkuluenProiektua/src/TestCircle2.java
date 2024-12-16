public class TestCircle2 {
    public static void main(String[] args) { // Program entry point
        // Declare and Construct an instance of the Circle class called c1
        Circle c1 = new Circle(2.0, "blue"); // Use 3rd constructor
        System.out.println("The radius is: " + c1.getRadius()); // use dot operator to invoke member methods
        // The radius is: 2.0
        System.out.println("The color is: " + c1.getColor());
        // The color is: blue
        System.out.printf("The area is: %.2f%n", c1.getArea());
        // The area is: 12.57

        // Declare and Construct another instance of the Circle class called c2
        Circle c2 = new Circle(2.0); // Use 2nd constructor
        System.out.println("The radius is: " + c2.getRadius());
        // The radius is: 2.0
        System.out.println("The color is: " + c2.getColor());
        // The color is: red
        System.out.printf("The area is: %.2f%n", c2.getArea());
        // The area is: 12.57

        // Declare and Construct yet another instance of the Circle class called c3
        Circle c3 = new Circle(); // Use 1st constructor
        System.out.println("The radius is: " + c3.getRadius());
        // The radius is: 1.0
        System.out.println("The color is: " + c3.getColor());
        // The color is: red
        System.out.printf("The area is: %.2f%n", c3.getArea());
        // The area is: 3.14
        
        Circle c4 = new Circle(5.0, "blue"); // Use 4rd constructor
        System.out.println("The radius is: " + c4.getRadius()); // use dot operator to invoke member methods
        // The radius is: 2.0
        System.out.println("The color is: " + c4.getColor());
        // The color is: blue
        System.out.printf("The area is: %.2f%n", c4.getArea());
        // The area is: 12.57

        System.out.printf("%10s %10s %10s %10s %n","Zirkulua","Erradioa","Kolorea","Azalera");
        System.out.println("=============================================");
        System.out.printf("%7s %11.2f %11S %10.2f%n","C1", c1.getRadius(),c1.getColor(),c1.getArea()); // use dot operator to invoke member methods
        System.out.printf("%7s %11.2f %11S %10.2f%n","C2", c2.getRadius(),c2.getColor(),c2.getArea()); // use dot operator to invoke member methods
        System.out.printf("%7s %11.2f %11S %10.2f%n","C3", c3.getRadius(),c3.getColor(),c3.getArea()); // use dot operator to invoke member methods
        System.out.printf("%7s %11.2f %11S %10.2f%n","C4", c4.getRadius(),c4.getColor(),c4.getArea()); // use dot operator to invoke member methods
    }
}
