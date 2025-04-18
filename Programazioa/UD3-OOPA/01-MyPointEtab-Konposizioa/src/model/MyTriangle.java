package model;

import model.MyPoint;

public class MyTriangle {
    private MyPoint v1,v2,v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        v1 = new MyPoint(x1, y1);
        v2 = new MyPoint(x2, y2);
        v3 = new MyPoint(x3, y3);
    }

    public MyTriangle (MyPoint v1, MyPoint v2, MyPoint v3){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public String toString(){
        return "[v1 =>"+v1.toString()+", v2 =>"+v2.toString()+", v3 => "+v3.toString()+"]";
    }

    public double getPerimeter(){
        double d1=0,d2=0,d3=0;
        d1 = v1.distance(v2);
        d2 = v2.distance(v3);
        d3 = v1.distance(v3);
        return d1 + d2 +d3;
    }

    public String getType(){
        double d1=0,d2=0,d3=0;
        d1 = v1.distance(v2);
        d2 = v2.distance(v3);
        d3 = v3.distance(v1);

        if(d1 == 0 || d2 == 0 || d3 == 0){
            return "Ez da triangelu bat";
        }else if(d1 == d2 && d2 == d3){
            return "aldeberdina";
        }else if((d1 == d2 && d2 != d3)||(d1 == d3 && d2 != d3)||(d2==d3&&d1 != d2)){
            return "isoszelea";
        }else{
            return "eskalenoa";
        }
    }


}
