# Exercise 1: Implementing an interface, overriding of methods

### Part A

Implement the `IPoint` interface representing a point in a two-dimensional Euclidean space.

Then, implement `IPoint` by creating a `Point` class, such that:

- Printing a point with coordinates x, y gives the output `(x,y)`:
    
    ```java
    IPoint p = new Point(1,2);
    System.out.println(p)
    // => (1,2)
    ```

- Two points are equal if they share the same coordinates

    ```java
    IPoint p1 = new Point(1,2);
    IPoint p2 = new Point(1,2);
    System.out.println(p1.equals(p2))
    // => true
    ```

- `getDistance(IPoint p)`: returns the Euclidean distance between two points with a precision of 3 decimal places.

    ```java
    IPoint p1 = new Point(1,1);
    IPoint p2 = new Point(4,5);
    System.out.println(p1.getDistance(p2))
    // => 5
    ```
  
  **Hint:** Use `BigDecimal` and `RoundingMode` to round up doubles.
  
  
- `compareTo(IPoint p)`: compares this point with the specified point for order. Returns a negative integer, zero, or a positive integer as this point is less than, equal to, or greater than the specified object. This point is less than the specified point if its `x` coordinate is lower than that of the specified point or if they have the same `x` coordinate, but this has a lower `y` coordinate.

    ```java
    IPoint p1 = new Point(1,1);
    IPoint p2 = new Point(4,5);
    System.out.println(p1.compareTo(p2))
    // => -3
    IPoint p2 = new Point(1,2);
    System.out.println(p1.compareTo(p2))
    // => -1
    IPoint p2 = new Point(2,1);
    System.out.println(p1.compareTo(p2))
    // => 1

Once you have created the `Point`class, go to `src/test/java/ex1/PointTest.java` and uncomment the indicated code blocks, setting up proper tests.

### Part B

Implement the `ITriangle` interface representing a triangle in a two-dimensional Euclidean space, using `IPoint` as basic building block. In particular, implement `ITriangle` by creating a `Triangle` class, such that:

- the constructor of `Triangle` checks whether the given points form a proper triangle, ruling out the two following degenerate cases: 
    - some points coincide; 
    - the points lie on the same line. 
  
    In both degenerate cases, the constructor must throw an `IllegalArgumentException`.

    ```java
    IPoint p1 = new Point(1,1);
    IPoint p2 = new Point(1,1);
    IPoint p3 = new Point(1,2);
    ITriangle t = new Triangle(p1,p2,p3);
    // => throws an IllegalArgumentException 
    ```
  
- `getPerimeter()` returns the perimeter of the triangle by summing up the length of the three sides of the triangle. Your perimeter should have a precision of 3 decimal places.

    ```java
    IPoint p1 = new Point(0,0);
    IPoint p2 = new Point(3,0);
    IPoint p3 = new Point(3,4);
    ITriangle t = new Triangle(p1,p2,p3);
    System.out.println(t.getPerimiter())
    // => 12
    ```
  
- two triangles are equal if they have the same coordinates (notice that such coordinates may not have been provided in the same order upon construction).

    ```java
    IPoint p1 = new Point(0,0);
    IPoint p2 = new Point(3,0);
    IPoint p3 = new Point(3,4);
    ITriangle t1 = new Triangle(p1,p2,p3);
    ITriangle t2 = new Triangle(p2,p3,p1);
    System.out.println(t1.equals(t2))
    // => true
    ```

    **Hint:** recall that points can be compared!

Then subclass the `Triangle` class by introducing the `EquilateralTriangle` class, representing an equilateral triangle, such that:

- the constructor does the additional check that the given points form sides having the same length. If this is not the case, an `IllegalArgumentException` is thrown.

- `getPerimeter()` overrides the implementation of the parent class, computing the perimeter by multiplying the length of one side by three.

Once you have created the `Triangle` and `EquilateralTriangle` classes, go to `src/test/java/ex1/TriangleTest.java` and `src/test/java/ex1/EquilateeralTriangleTest.java` and uncomment the indicated code blocks, setting up proper tests.
