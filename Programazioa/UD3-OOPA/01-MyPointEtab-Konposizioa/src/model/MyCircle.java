package model;
import model.MyPoint;
public class MyCircle {
    private MyPoint center;
    private int radius;

    public MyCircle(){
        this.center = new MyPoint(0,0);
        this.radius = 1;
    }

    public MyCircle(int x, int y, int radius){
        this.center = new MyPoint(x,y);
        this.radius = radius;
    }

    public MyCircle(MyPoint center, int radius){
        this.center = center;
        this.radius = radius;
    }

    //Distance (double)
    public double distance(MyPoint another){
        double k1 = this.center.getX() - another.getX();
        double k2 = this.center.getY() - another.getY();
        return Math.sqrt(Math.pow(k1,2)+Math.pow(k2,2));
    }

    //inInside (boolean)
    public boolean isInside(MyPoint puntua){
        boolean barne = false;
        if(this.center.distance(puntua) <= radius){
            barne = true;
        }
        return barne;
    }

    public double getArea(){
        double azalera = (double)((radius * radius) * Math.PI);
        return azalera;
    }

    public MyPoint getcenter(){
        return this.center;
    }

    public int getcenterX(){
        return center.getX();
    }

    public int getcenterY(){
        return center.getY();
    }

    public int[] getcenterXY(){
        int[] arraia = {center.getX(),center.getY()};
        return arraia;
    }

    public double getCircumference(){
        double zirkunferentzia = (double)(radius * 2 * Math.PI);
        return zirkunferentzia;
    }

    public int getRadius(){
        return this.radius;
    }

    public void setCenter(MyPoint center){
        this.center = center;
    }

    public void setCenterX(int x){
        this.center.setX(x);
    }

    public void setCenterY(int y){
        this.center.setY(y);
    }

    public void setCenterXY(int x, int y){
        this.center.setXY(x, y);;
    }

    public void setRadius(int radius){
        this.radius = radius;
    }

    public String toString(){
        return "(Radius = " + this.radius + ", Center = "+center.toString()+")";
    }
}
