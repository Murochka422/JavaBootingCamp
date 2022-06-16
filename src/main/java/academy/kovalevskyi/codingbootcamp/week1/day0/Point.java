package academy.kovalevskyi.codingbootcamp.week1.day0;

import java.util.Objects;

public class Point implements Comparable<Point> {

  int coordinateX;
  int coordinateY;

  public Point(final int coordinateX, final int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  public int getX() {
    return coordinateX;
  } 

  public int getY() {
    return coordinateY;
  } 

  public Point sum(final Point that) {
    return new Point(this.coordinateX + that.coordinateX, this.coordinateY + that.coordinateY);
  }
  
  public Point updateX(int newX) {
    return new Point(newX, this.coordinateY);
  }

  public Point updateY(int newY) {
    return new Point(this.coordinateX, newY);
  }

  public int distanceTo(Point that) {
    return (int) (NumberUtils.power(this.coordinateX - that.coordinateX, 2)
                + NumberUtils.power(this.coordinateY - that.coordinateY, 2));
  }  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (this.getClass() != o.getClass()) {
      return false;
    }
    Point that = (Point) o;
    return (getX() == that.getX()) && (getY() == that.getY());
  }

  @Override 
  public int compareTo(Point that) {
    return this.hashCode() - that.hashCode();
  }
  
  @Override
  public int hashCode() {
    return coordinateX + coordinateY;
  }

  @Override
  public String toString() {
    return String.format("Point{X: %d, Y: %d}", coordinateX, coordinateY);
  }
}


