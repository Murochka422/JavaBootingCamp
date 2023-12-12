package academy.kovalevskyi.algorithms.week0.day1;

public class Tasks {
  public static class Node<T> {
    public Node<T> next;
    public T value;
  }

  public static <T> Node<T> findMiddleInOneGo(Node<T> start) {
    Node<T> step = start;
    Node[] arrNode = new Node[100];
    int length = 0;
    while (step != null) {
      arrNode[length] = step;
      step = step.next;
      length++;
    }
    return arrNode[length / 2];
  }

  public static <T> boolean hasCycle(Node<T> start) {
    Node<T> step = start;
    int count = 0;
    while (step != null) {
      Node<T> step2 = start;
      for (int i = 0; i < count; i++) {
        if (step2 == step) {
          return true;
        }
        step2 = step2.next;
      }
      step = step.next;
      count++;
    }
    return false;
  }
}
