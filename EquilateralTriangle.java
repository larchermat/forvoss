package ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EquilateralTriangle extends Triangle{
    public EquilateralTriangle(IPoint A, IPoint B, IPoint C) {
        super(A, B, C);
        if(A.getDistance(B)!= A.getDistance(C) || A.getDistance(B)!=B.getDistance(C))
            throw new IllegalArgumentException("Not equilateral");
    }

    @Override
    public double getPerimeter() {
        return BigDecimal.valueOf(3 * A.getDistance(B)).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }
}