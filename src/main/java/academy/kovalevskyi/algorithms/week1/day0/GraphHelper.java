package academy.kovalevskyi.algorithms.week1.day0;

public class GraphHelper {
  public static boolean equals(GraphBinaryNode<?> left, GraphBinaryNode<?> right) {
    return right.equals(left);
  }

  public static <T> GraphBinaryNode<T> invertGraph(GraphBinaryNode<T> root) {
    if (root == null) {
      return null;
    }
    root = swapGraph(root);
    return new GraphBinaryNode<T>(invertGraph(root.left()), invertGraph(root.right()),
                                                                        root.value());
  }

  public static <T> GraphBinaryNode<T> swapGraph(GraphBinaryNode<T> graph) {
    return new GraphBinaryNode<T>(graph.right(), graph.left(), graph.value());
  }
}
