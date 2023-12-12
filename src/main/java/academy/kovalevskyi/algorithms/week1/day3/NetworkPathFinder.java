package academy.kovalevskyi.algorithms.week1.day3;

import java.util.*;

public class NetworkPathFinder {
  private static Set<Node> seenNodes = new HashSet<>();
  private static Map<Node, Integer> shortest = new HashMap<>();

  public static int shortestPath(Node start, Node end) {
    if (start == null || end == null || start == end) {
      return 0;
    }
    Node step = start;
    for (Map.Entry<Node, Integer> entry : step.connections.entrySet()) {
      Node next = entry.getKey();
      checkNode(next);
    }
    return shortest.get(end);
  }

  private static void checkNode(final Node step) {
    if (step == null || step.connections == null) {
      return;
    }
    for (Map.Entry<Node, Integer> entry : step.connections.entrySet()) {
      Node next = entry.getKey();
      if (next != null) {
        if (!seenNodes.contains(next)) {
          if (!shortest.containsKey(next) || shortest.get(next) + shortest.get(step) > next.distance) {
            shortest.put(next, next.distance);
          }
        }
      }
      seenNodes.add(step);
    }
  }
}
