package ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle implements ITriangle{
    IPoint A,B,C;
    public Triangle(IPoint A,IPoint B,IPoint C){
        if(A.equals(B))
            System.out.println("A=B");
        if(A.equals(C))
            System.out.println("A=C");
        if(B.equals(C))
            System.out.println("B=C");
        System.out.println("Pendenza A-B= "+(B.getY()- A.getY())/(B.getX()-A.getX()));
        System.out.println("Pendenza B-C= "+(C.getY()- B.getY())/(C.getX()-B.getX()));
        if(A.equals(B)|| A.equals(C) || B.equals(C) || (B.getY()- A.getY())/(B.getX()-A.getX())==(C.getY()- B.getY())/(C.getX()-B.getX()))
            throw new IllegalArgumentException("Degenerate triangle");
        /*if(((Point)A).compareTo(B)==0 || ((Point)A).compareTo(C)==0 || ((Point)B).compareTo(C)==0)*/
        /*A.compareTo(B)==0 || A.compareTo(C)==0 || B.compareTo(C)==0*/
        this.A=A;
        this.B=B;
        this.C=C;
    }
    @Override
    public IPoint getA() {
        return A;
    }

    @Override
    public IPoint getB() {
        return B;
    }

    @Override
    public IPoint getC() {
        return C;
    }

    @Override
    public double getPerimeter() {
        double p2= A.getDistance(B)+A.getDistance(C)+ B.getDistance(C);
        return new BigDecimal(p2).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        ITriangle t=(ITriangle) obj;

        if(A.equals(t.getA())){
            if(B.equals(t.getB()))
                return C.equals(t.getC());
            if(B.equals(t.getC()))
                return C.equals(t.getB());
        }
        if(A.equals(t.getB())){
            if(B.equals(t.getA()))
                return C.equals(t.getC());
            if(B.equals(t.getC()))
                return C.equals(t.getA());
        }
        if(A.equals(t.getC())){
            if(B.equals(t.getA()))
                return C.equals(t.getB());
            if(B.equals(t.getB()))
                return C.equals(t.getA());
        }
        /*
        if(A.compareTo(t.getA())==0){
            if(B.compareTo(t.getB())==0)
                return C.equals(t.getC());
            if(B.compareTo(t.getC())==0)
                return C.equals(t.getB());
        }
        if(A.compareTo(t.getB())==0){
            if(B.compareTo(t.getA())==0)
                return C.equals(t.getC());
            if(B.compareTo(t.getC())==0)
                return C.equals(t.getA());
        }
        if(A.compareTo(t.getC())==0){
            if(B.equals(t.getB()))
                return C.equals(t.getA());
            if(B.equals(t.getC()))
                return C.equals(t.getB());
        }*/
        return false;
    }
}
