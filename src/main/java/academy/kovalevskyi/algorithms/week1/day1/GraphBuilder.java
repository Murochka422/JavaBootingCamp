package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;

public interface GraphBuilder<T> {
  public default <T> GraphBinaryNode<T> withVisible() {
    return null;
  }
}
