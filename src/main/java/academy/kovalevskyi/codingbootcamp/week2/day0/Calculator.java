package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class Calculator {

  public static void main(String[] args) throws IllegalArgumentException {
    if (args.length != 3) {
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
    } else {
      int a = StringUtils.toInt(args[0].toCharArray());
      int b = StringUtils.toInt(args[2].toCharArray());
      char operator = args[1].charAt(0);
      if ((b == 0) && ((operator == '/') || (operator == '%'))) {
        System.out.println("Division by zero is impossible!");
      } else {
        System.out.printf("result: %s\r\n", arithmeticOperation(a, b, operator));
      }
    }
  }

  public static Number arithmeticOperation(int a, int b, char operator) throws
      IllegalArgumentException, NullPointerException {
    return switch (operator) {
      case '+' -> a + b;
      case '-' -> (long) (a - b);
      case '*' -> (long) a * (long) b;
      case '/' -> (double) a / b;
      case '%' -> a % b;
      default -> 0;
    };
  }

  private static boolean isArithmeticSign(String s) throws IllegalArgumentException {
    char[] characters = s.toCharArray();
    char[] signs = new char[] {'+', '-', '/', '*', '%'};
    if (characters.length != 1) {
      return false;
    }
    for (char ch : signs) {
      if (characters[0] == ch) {
        return true;
      }
    }
    return false;
  }

}
