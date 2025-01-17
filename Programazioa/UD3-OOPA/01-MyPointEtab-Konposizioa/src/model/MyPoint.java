package model;

public class MyPoint {
    private int X ,Y;

    public MyPoint(){
        this.X = 0;
        this.Y = 0;
    }

    public MyPoint(int x,int y){
        this.X = x;
        this.Y = y;
    }

    public double distance(){
        return Math.sqrt(Math.pow(this.X,2)+Math.pow(this.Y,2));
    }

    public double distance(MyPoint another){
        double k1 = this.X - another.X;
        double k2 = this.Y - another.Y;
        return Math.sqrt(Math.pow(k1,2)+Math.pow(k2,2));
    }

    public double distance(int x, int Y){
        double k1 = this.X - x;
        double k2 = this.Y - y;
        return Math.sqrt(Math.pow(k1,2)+Math.pow(k2,2));
    }

    public int getX(){
        return this.X;
    }

    public int getY(){
        return this.Y;
    }

    public int[] getXY(){
        int[] arraia = {X,Y};
        return arraia;
    }

    public void setX(int x){
        X = x;
    }

    public void setY(int y){
        Y = y;
    }

    public void setXY(int X, int Y){
        this.X = X;
        this.Y = Y;
    }

    public String toString(){
        return "(" + this.X + ","+this.Y+")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // Comparar referencias (mismo objeto en memoria)
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // Comparar tipos
            return false;
        }
        MyPoint other = (MyPoint) obj; // Hacer un cast seguro
        return this.getX() == other.getX() && this.getY() == other.getY(); // Comparar valores
    }
}
