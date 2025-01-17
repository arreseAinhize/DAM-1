package model;
import model.MyPoint;

public class MyRectangle {
    private MyPoint topLeft,bottonRight;

    public MyRectangle(MyPoint topLeft,MyPoint bottonRight){
        this.topLeft = topLeft;
        this.bottonRight = bottonRight;
    }

    public double getAzalera(){
        MyPoint bottonLeft = new MyPoint(bottonRight.getX(),topLeft.getY());
        double h = 0, x = 0;
        h = topLeft.distance(bottonLeft);
        x = bottonLeft.distance(bottonRight);

        return x * h;
    }

    public double getPerimetroa(){
        MyPoint bottonLeft = new MyPoint(bottonRight.getX(),topLeft.getY());
        double h = 0, x = 0;
        h = topLeft.distance(bottonLeft);
        x = bottonLeft.distance(bottonRight);

        return (x*2)+(h*2);
    }

    public String toString(){
        return "("+topLeft.toString()+","+bottonRight.toString()+")";
    }
}
