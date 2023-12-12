package academy.kovalevskyi.algorithms.week1.day1;

import java.util.Arrays;

public class XoBoard {
  private final XoFigure[][] state = new XoFigure[3][3];

  public XoBoard() {
  }

  public XoBoard(XoBoard copy) {
    for (int i = 0; i < state.length; i++) {
      for (int j = 0; j < state[0].length; j++) {
        state[i][j] = copy.getFigure(i, j);
      }
    }
  }

  public XoFigure getFigure(int x, int y) {
    return state[x][y];
  }

  public XoFigure[][] getState() {
    return state;
  }

  public void setFigure(int x, int y, XoFigure figure) {
    if (state[x][y] != null) {
      return;
    }
    state[x][y] = figure;
  }

  public XoFigure hasWinner() {
    for (int i = 0; i < state.length; i++) {
      if (state[i][0] != null && state[i][0] == state[i][1] && state[i][0] == state[i][2]) {
        return getFigure(i, 0);
      }
      if (state[0][i] != null && state[0][i] == state[1][i] && state[0][i] == state[2][i]) {
        return getFigure(0, i);
      }
    }
    if (isDiagonal()) {
      return getFigure(1, 1);
    }
    return null;
  }

  public boolean tie() {
    return isFull() && hasWinner() == null;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (this == o) {
      return true;
    }
    if (!(o instanceof XoBoard)) {
      return false;
    }
    return hashCode() == o.hashCode();
  }

  @Override
  public int hashCode() {
    int code = 1;
    for (XoFigure[] xoFigures : state) {
      if (xoFigures != null) {
        code = 31 * code + Arrays.hashCode(xoFigures);
      }
    }
    return code;
  }

  public boolean isFull() {
    for (XoFigure[] xoFigures : state) {
      for (int j = 0; j < state[0].length; j++) {
        if (xoFigures[j] == null) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isEmpty() {
    for (XoFigure[] xoFigures : state) {
      for (int j = 0; j < state[0].length; j++) {
        if (xoFigures[j] != null) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isDiagonal() {
    return state[1][1] != null && ((state[0][0] ==state [1][1] && state [1][1] == state [2][2])
         || (state[2][0] ==state [1][1] && state [1][1] == state [0][2]));
  }
}
