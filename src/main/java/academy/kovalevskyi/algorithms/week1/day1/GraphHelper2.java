package academy.kovalevskyi.algorithms.week1.day1;

import academy.kovalevskyi.algorithms.week1.day0.GraphBinaryNode;

import java.util.*;

public class GraphHelper2 {
  public static boolean includesDepthFirstSearch(GraphBinaryNode<?> root, Object value) {
    List<GraphBinaryNode<?>> visited = new LinkedList<>();
    return DFS(root, value, visited);
  }

  private static boolean DFS(GraphBinaryNode<?> root, Object value, List<GraphBinaryNode<?>> visited) {
    visited.add(root);
    if (root == null) {
      return false;
    }
    if (root.value().equals(value)) {
      return true;
    }
    boolean contains = false;
    if (!visited.contains(root.left()))
      contains = DFS(root.left(), value, visited);
    if (!contains &&!visited.contains(root.right())) {
      contains = DFS(root.right(), value, visited);
    }
    return contains;
  }

  public static boolean includesBreathFirstSearch(GraphBinaryNode<?> root, Object value) {
    if (root == null) {
      return false;
    }
    if (root.value().equals(value)) {
      return true;
    }
    GraphBinaryNode<?> step;
    Queue<GraphBinaryNode<?>> q = new ArrayDeque<>();
    q.add(root);
    while (!q.isEmpty()) {
      step = q.poll();
      if (step.value().equals(value)) {
        return true;
      }
      if (step.left() != null) {
        q.add(step.left());
      }
      if (step.right() != null) {
        q.add(step.right());
      }
    }
    return false;
  }
}
