package academy.kovalevskyi.codingbootcamp.week2.day1;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class TextPrinter2 extends BoxGenerator {
  String text;

  public static void main(String[] args) throws IllegalArgumentException {
    if (args.length != 2) {
      System.out.printf("Please provide 2 input arguments, current amount: %d\n", args.length);
    } else {
      String text = args[1].trim();
      int symbolLength = args[0].length();
      if (symbolLength > 1) {
        System.out.printf("First arguments length should be 0 or 1, now it is: %d\n", symbolLength);
      } else {
        char s = symbolLength == 0 ? Character.MIN_VALUE : args[0].charAt(0);
        TextPrinter2 box = new TextPrinter2(text, s);
        box.draw();
      }
    }
  }

  public TextPrinter2(String text, char side) {
    super(text.length() + 4, 3, side, side);
    this.text = text;
    generate();
  }

  @Override
  public void generateInside() {
    strings[1] = side == '\u0000' ? String.format(" %s \n", text)
        : String.format("%1$s %2$s %1$s\n", side, text);
  }
}
