package academy.kovalevskyi.algorithms.week1.day2;

import java.util.HashSet;
import java.util.Set;

public class Node {

  private final Set<Node> neighbours = new HashSet<Node>();

  public static void connect(Node left, Node right) {
    left.neighbours.add(right);
    right.neighbours.add(left);
  }

  public Set<Node> getNeighbours(){
    return neighbours;
  }
}
