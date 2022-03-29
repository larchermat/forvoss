package ex1;

public interface IPoint extends Comparable<IPoint> {

  double getX();

  double getY();

  double getDistance(IPoint p);
}
