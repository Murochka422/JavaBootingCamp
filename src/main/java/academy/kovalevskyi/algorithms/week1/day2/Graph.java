package academy.kovalevskyi.algorithms.week1.day2;

import java.util.*;

public class Graph {
  private Map<Node, Integer> components;
  private int count;

  private Graph(Map<Node, Integer> map, int count) {
    components = map;
    this.count = count;
  }

  public static Graph generateGraph(Set<Node> nodes) {
    if (nodes == null) {
      return new Graph(null, 0);
    }
    Map<Node, Integer> map = new HashMap<>();
    List<Set<Node>> neighbourSet = new ArrayList<>();
    Iterator itr = nodes.iterator();
    while (itr.hasNext()) {
      Node step = (Node) itr.next();
      Set<Node> neighbour = new HashSet<>();
      for (Node node : nodes) {
        Set<Node> visited = new HashSet<>();
        if (DFS(step, node, visited)) {
          neighbour.add(node);
        }
      }
      if (!neighbourSet.contains(neighbour)) {
        neighbourSet.add(neighbour);
      }
      int index = 0;
      for (int i = 0; i < neighbourSet.size(); i++) {
        if (neighbourSet.get(i).contains(step)) {
          index = i;
          break;
        }
      }
      map.put(step, index);
    }
    return new Graph(map, neighbourSet.size());
  }

  public int countComponents() {
    return count;
  }

  public int getComponentId(Node node) {
    return components.get(node);
  }

  private static boolean DFS(Node root, Node node, Set<Node> visited) {
    visited.add(root);
    if (root == null) {
      return false;
    }
    if (root.equals(node)) {
      return true;
    }
    if (node.getNeighbours().contains(root)) {
      return true;
    }
    boolean contains = false;
    for (Node step : root.getNeighbours()) {

      if (!visited.contains(step)) {
        visited.add(step);
        contains = DFS(step, node, visited);
      }
      if (contains) {
        return true;
      }
    }
    return false;
  }
}
