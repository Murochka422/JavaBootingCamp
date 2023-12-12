package academy.kovalevskyi.algorithms.week1.day1;

import java.util.Set;

public class XoHelper {
  private static Set<XoBoard> boardSet;

  public static Set<XoBoard> generateEndStates() {
    generateNext(new XoBoard(), XoFigure.figureX);
    return boardSet;
  }

  private static void generateNext(XoBoard state, XoFigure sigh) {
    if (state.isFull()) {
      return;
    }
    int length = state.getState().length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j< length; j++) {
        if (state.getState()[i][j] != null) {
          XoBoard newState = new XoBoard(state);
          newState.setFigure(i, j, sigh);
          if (newState.tie() || newState.hasWinner() != null) {
            boardSet.add(newState);
          }
          generateNext(newState, sigh ==XoFigure.figureX ? XoFigure.figureO : XoFigure.figureX);
        }
      }
    }
  }
}