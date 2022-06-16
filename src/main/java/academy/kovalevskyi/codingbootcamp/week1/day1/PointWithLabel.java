package academy.kovalevskyi.codingbootcamp.week1.day1;

import academy.kovalevskyi.codingbootcamp.week1.day0.Point;
import java.util.Comparator;
import java.util.function.Function;

public class PointWithLabel extends PointWithValue<String> {
  
  //private String value;

  public PointWithLabel(final int coordinateX, final int coordinateY, final String value) {
    super(coordinateX, coordinateY, value);
  }


  public String getLabel() {
    return this.getValue();
  }

  @Override 
  public int compareTo(Point that) {
    if (that instanceof PointWithLabel) {
      return this.getLabel().compareTo(((PointWithLabel) that).getLabel());
    }
    return super.compareTo(that);
  }
} 
