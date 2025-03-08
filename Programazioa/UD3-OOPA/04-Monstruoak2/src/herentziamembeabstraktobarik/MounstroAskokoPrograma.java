package herentziamembeabstraktobarik;

import java.util.Scanner;

public class MounstroAskokoPrograma {
    private static Monster[] mk;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear monstruos por tipo y cantidad");
            System.out.println("2. Crear monstruos indicando la cantidad de cada tipo");
            System.out.println("3. Mostrar monstruos creados");
            System.out.println("4. Iniciar batalla entre monstruos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = in.nextInt();
            in.nextLine();

            switch (opcion) {
                case 1:
                    clearConsole();
                    crearMonstruosPorTipo();
                    break;
                case 2:
                    clearConsole();
                    crearMonstruosPorCantidad();
                    break;
                case 3:
                    clearConsole();
                    mostrarMonstruos();
                    break;
                case 4:
                    clearConsole();    
                    iniciarBatalla();
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }

        in.close();
    }

    private static void crearMonstruosPorTipo() {
        System.out.print("Introduce el tipo de monstruo (fire, water, stone): ");
        String tipo = in.nextLine().toLowerCase();
        System.out.print("Introduce la cantidad: ");
        int cantidad = in.nextInt();
        monstruoakSortu(tipo, cantidad);
        System.out.println("¡Monstruos creados con éxito!");
    }

    private static void crearMonstruosPorCantidad() {
        System.out.print("Introduce cantidad de FireMonsters: ");
        int fireKop = in.nextInt();
        System.out.print("Introduce cantidad de WaterMonsters: ");
        int waterKop = in.nextInt();
        System.out.print("Introduce cantidad de StoneMonsters: ");
        int stoneKop = in.nextInt();
        monstruoakSortu(fireKop, waterKop, stoneKop);
        System.out.println("¡Monstruos creados con éxito!");
    }

    private static void mostrarMonstruos() {
        if (mk == null || mk.length == 0) {
            System.out.println("No hay monstruos creados.");
        } else {
            System.out.println("Lista de monstruos:");
            monstruoakBistaratu();
        }
    }

    private static void iniciarBatalla() {
        if (mk == null || mk.length == 0) {
            System.out.println("No hay monstruos creados para la batalla.");
            return;
        }

        System.out.print("Tipo del atacante (fire, water, stone): ");
        String attackTipe = in.next().toLowerCase();
        System.out.print("Tipo del atacado (fire, water, stone): ");
        String attackedTipe = in.next().toLowerCase();
        monstruoenBurruka(attackTipe, attackedTipe);
    }

    public static void monstruoakSortu(int fireKop, int waterKop, int stoneKop){
        mk = new Monster[fireKop + waterKop+ stoneKop];
        int mosterkop = 0;

        for(int i = 0; i < fireKop; i++ ){
            mk[mosterkop] = new FireMonster("FM"+mosterkop);
            mosterkop++;
        }

        for(int i = 0; i < waterKop; i++ ){
            mk[mosterkop] = new WaterMonster("WM"+mosterkop);
            mosterkop++;
        }

        for(int i = 0; i < stoneKop; i++ ){
            mk[mosterkop] = new StoneMonster("SM"+mosterkop);
            mosterkop++;
        }
        monstruoakBistaratu();
    }

    public static void monstruoakSortu(String mota, int monstKop){
        mk = new Monster[monstKop];
        int mosterkop = 0;

        if( mota.equals("Fire") || mota.equals("fire") ){
            for(int i = 0; i < monstKop; i++ ){
                mk[i] = new FireMonster("FM"+mosterkop);
                mosterkop++;
            }
        }else if( mota.equals("Water") || mota.equals("water") ){
            for(int i = 0; i < monstKop; i++ ){
                mk[i] = new WaterMonster("WM"+mosterkop);
                mosterkop++;
            }
        }else{
            for(int i = 0; i < monstKop; i++ ){
                mk[i] = new StoneMonster("SM"+mosterkop);
                mosterkop++;
            }
        }
        monstruoakBistaratu();
    }

    public static void monstruoakBistaratu(){
        for (Monster monster : mk) {
            System.out.println(monster.getName());
        }
    }

    public static void monstruoenBurruka(String attackTipe, String attackedTipe) {
        if (attackTipe.equals(attackedTipe)) {
            System.out.println("No pasó nada");
        } else if (attackTipe.equals("water") && attackedTipe.equals("fire")) {
            System.out.println("¡El ataque fue efectivo! El agua apaga el fuego.");
        } else if (attackTipe.equals("fire") && attackedTipe.equals("stone")) {
            System.out.println("¡El ataque fue efectivo! El fuego puede debilitar la piedra.");
        } else if (attackTipe.equals("stone") && attackedTipe.equals("water")) {
            System.out.println("¡El ataque fue efectivo! La piedra puede hundirse en el agua.");
        } else {
            System.out.println("El ataque no fue muy efectivo.");
        }
    }
    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
