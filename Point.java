package ex1;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Point implements IPoint{
    double x,y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getDistance(IPoint p) {
        double d=Math.sqrt(Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2));
        d=new BigDecimal(d).setScale(3, RoundingMode.HALF_UP).doubleValue();
        return d;
    }

    @Override
    public int compareTo(IPoint o) {
        if(x==o.getX())
            return (int) (y-o.getY());
        if(-1<x-o.getX() && 1>x-o.getX())
            return -1;
        return (int)(x-o.getX());
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        IPoint o= (IPoint) obj;

        return compareTo(o) == 0;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
