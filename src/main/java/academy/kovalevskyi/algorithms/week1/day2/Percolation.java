package academy.kovalevskyi.algorithms.week1.day2;

import java.util.HashSet;
import java.util.Set;

public class Percolation {
  private Graph graph;
  private boolean[][] field;

  public Percolation(boolean[][] field) {
    this.field = field;
  }

  public boolean percolate() {
    if (field == null || field.length == 0) {
      return false;
    }

    Node[][] nodes = new Node[field.length][field[0].length];
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[0].length; j++) {
        if (field[i][j]) {
          nodes[i][j] = new Node();
        }
      }
    }

    Set<Node> set = new HashSet<Node>();

    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field[0].length; j++) {
        if (field[i][j]) {
          if (j < field[0].length - 1 && field[i][j + 1]) {
            Node.connect(nodes[i][j], nodes[i][j + 1]);
          }
          if (j > 0 && field[i][j - 1]) {
            Node.connect(nodes[i][j], nodes[i][j - 1]);
          }
          if (i > 0 && field[i - 1][j]) {
            Node.connect(nodes[i][j], nodes[i - 1][j]);
          }
          if (i < field.length - 1 && field[i + 1][j]) {
            Node.connect(nodes[i][j], nodes[i + 1][j]);
          }
          set.add(nodes[i][j]);
        }
      }
    }

    graph = Graph.generateGraph(set);

    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field.length; j++) {
        if (field[i][0] && field[j][field[0].length - 1]) {
          if (graph.getComponentId(nodes[i][0]) == graph.getComponentId(nodes[j][field[0].length - 1])) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    boolean[][] arr = {
        {true, false, true, false},
        {false, false, false, false},
        {false, false, false, false},
        {true, true, true, true}
    };
    Percolation p = new Percolation(arr);
    System.out.println(p.percolate());
  }
}
