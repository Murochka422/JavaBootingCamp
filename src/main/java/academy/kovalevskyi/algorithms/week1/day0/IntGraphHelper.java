package academy.kovalevskyi.algorithms.week1.day0;

public class IntGraphHelper {

  public static GraphBinaryNode<Integer> createNode(Integer value) {
    return new GraphBinaryNode<>(null, null, value);
  }

  public static GraphBinaryNode<Integer> addNode(GraphBinaryNode<Integer> root, Integer value) {
    if (root == null) {
      return createNode(value);
    }
    if (value < root.value()) {
      if (root.left() == null) {
        return new GraphBinaryNode<>(createNode(value), root.right(), root.value());
      }
      return new GraphBinaryNode<>(addNode(root.left(), value), root.right(), root.value());
    }
    if (root.right() == null) {
      return new GraphBinaryNode<>(root.left(), createNode(value), root.value());
    }
    return new GraphBinaryNode<>(root.left(), addNode(root.right(), value), root.value());
  }

  public static boolean contains(GraphBinaryNode<Integer> root, Integer value) {
    if (root == null) {
      return false;
    }
    if (root.value() == value) {
      return true;
    }
    if (root.value() < value) {
      return contains(root.left(), value);
    }
    return contains(root.right(), value);
  }
}
