package academy.kovalevskyi.codingbootcamp.week2.day3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View implements Reader, Printer {
  private final char player1 = 'X';
  private final char player2 = 'O';

  public char getPlayer1() {
    return player1;
  }

  public char getPlayer2() {
    return player2;
  }

  @Override
  public int read() {
    Scanner scanner = new Scanner(System.in);
    int number = 0;

    try {
      number = scanner.nextInt();
      /*if (number < 0 || number >  limit) {
        throw new InputMismatchException();
      }*/
    } catch (InputMismatchException e) {
      print("Only numbers. Try again: ");
      read();
    }
    return number;
  }

  @Override
  public void print(String message) {
    System.out.print(message);
  }

  @Override
  public void showGrid(Model model) {
    StringBuilder firstLine = new StringBuilder("    ");
    for (int i = 0; i < model.length(); i++) {
      firstLine.append(i);
      firstLine.append("   ");
    }
    print(firstLine.toString() + '\n');
    String horisontalLine = " " + "-----".repeat(model.length()) + "\n";
    print(horisontalLine);
    for (int i = 0; i < model.length(); i++) {
      StringBuilder verticalLine = new StringBuilder(i + " |");
      for (int j = 0; j < model.length(); j++) {
        verticalLine.append(model.isEmpty(i, j) ? "   |"
            : String.format(" %s |", model.getSign(i, j)));
      }
      print(verticalLine.toString() + '\n');
      print(horisontalLine);
    }
  }

  @Override
  public PointSign inputData(char ch, Model model) {
    print(String.format("Step for %s \n", ch));
    PointSign p = null;
    while (p == null) {
      print("Input x: ");
      int x = read();
      print("Input y: ");
      int y = read();
      if ((x < 0) || (x >= model.length()) || (y < 0) || (y >= model.length())) {
        print("Input a number of cell in the grid\n");
      } else if (model.isEmpty(x, y)) {
        p = new PointSign(x, y, ch);
      } else {
        print("This cell is not empty\n");
      }
    }
    return p;
  }
}
