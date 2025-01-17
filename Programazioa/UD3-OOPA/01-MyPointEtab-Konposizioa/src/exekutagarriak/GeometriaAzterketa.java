package exekutagarriak;

import model.*;
import java.util.Scanner;

public class GeometriaAzterketa {
    private static double nota = 0;
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int galdera = 0;
        boolean erantzuna = false;
        while(galdera <6){
            if(galdera == 0){
                System.out.println("Zein da p1(7,5) eta p2(1,3) puntuen arteko distantzia? (borobilduta)");
                erantzuna = galdera1();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }else if(galdera == 1){
                System.out.println("Zein dintantzia dago zirkulu1 - zirkulu2 en artean? (borobilduta)");
                erantzuna = galdera2();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }else if (galdera == 2){
                System.out.println("Hirugarren zirkuluak koordenatuen jatorria barne ahal du? (true/false)");
                erantzuna = galdera3();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }else if (galdera == 3){
                System.out.println("Zein da hurrengo triangeluaren perimetroa? (borobilduta)");
                erantzuna = galdera4();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }else if (galdera ==4){
                System.out.println("Zein triangelu mota da?");
                erantzuna = galdera5();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }else if(galdera == 5){
                System.out.println("Zein da hurrengo laukiaren perimetroa? (borobilduta)");
                erantzuna = galdera6();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }else{
                System.out.println("Zein da hurrengo laukiaren perimetroa? (borobilduta)");
                erantzuna = galdera7();
                if(erantzuna == true){
                    nota++;
                }
                galdera++;
            }
        }
        System.out.println("Zure nota:( "+ nota + "/"+galdera+")-tik");
    }

    public static boolean galdera1(){
        boolean erantzuna = false;
        int erabErantzuna = in.nextInt();
        
        MyPoint p1 = new MyPoint(7,5);
        MyPoint p2 = new MyPoint(1,3);

        int erabOrdanagailua = (int)p1.distance(p2);

        if(erabErantzuna == erabOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }

    public static boolean galdera2(){
        boolean erantzuna = false;
        MyCircle zirk1 = new MyCircle(new MyPoint(4, 2), 15);
        MyCircle zirk2 = new MyCircle(0,4 ,1);
        System.out.println("zirkulu1 =>" + zirk1.toString()+"\nzirkulu2 =>"+zirk2.toString());
        
        int erabErantzuna = in.nextInt();
        int eranOrdanagailua = (int)zirk1.distance(new MyPoint(zirk2.getcenterX(), zirk2.getcenterY()));

        if(erabErantzuna == eranOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }

    public static boolean galdera3(){
        boolean erantzuna = false;
        MyCircle zirk3 = new MyCircle(5,3 ,1);
        System.out.println("zirkulu3 =>" + zirk3.toString());

        boolean erabErantzuna = in.nextBoolean();
        boolean eranOrdanagailua = zirk3.isInside(new MyPoint(0,0));

        if(erabErantzuna == eranOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }

    public static boolean galdera4(){
        boolean erantzuna = false;
        MyTriangle trian1 = new MyTriangle(0, 14, -6, 8, 6, 8);
        System.out.println("Triangelua =>" + trian1.toString());

        int erabErantzuna = in.nextInt();
        int eranOrdanagailua = (int)trian1.getPerimeter();
        if(erabErantzuna == eranOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }

    public static boolean galdera5(){
        boolean erantzuna = false;
        MyTriangle trian1 = new MyTriangle(0, 14, -6, 8, 6, 8);
        System.out.println("Triangelua =>" + trian1.toString());

        String erabErantzuna = in.next();
        String eranOrdanagailua = trian1.getType();
        if(erabErantzuna == eranOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }

    public static boolean galdera6(){
        boolean erantzuna = false;
        MyRectangle laukia = new MyRectangle(new MyPoint(1, 5), new MyPoint(7, 3));
        System.out.println("Laukia =>" + laukia.toString());

        int erabErantzuna = in.nextInt();
        int eranOrdanagailua = (int)laukia.getPerimetroa();
        if(erabErantzuna == eranOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }

    public static boolean galdera7(){
        boolean erantzuna = false;
        MyRectangle laukia = new MyRectangle(new MyPoint(2, 7), new MyPoint(9, 5));
        System.out.println("Laukia =>" + laukia.toString());

        int erabErantzuna = in.nextInt();
        int eranOrdanagailua = (int)laukia.getAzalera();
        if(erabErantzuna == eranOrdanagailua){
            erantzuna = true;
        }
        return erantzuna;
    }
}
