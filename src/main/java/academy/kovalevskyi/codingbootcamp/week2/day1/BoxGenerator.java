package academy.kovalevskyi.codingbootcamp.week2.day1;

import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class BoxGenerator {
  char corner;
  char side;
  String[] strings;
  int width;

  public static void main(String[] args) throws IllegalArgumentException {
    if (args.length != 4) {
      System.out.printf("Please provide 4 input arguments, current amount: %d\n", args.length);
    } else {
      int w = StringUtils.toInt(args[0].toCharArray());
      int h = StringUtils.toInt(args[1].toCharArray());
      if ((w < 0) || (h < 0)) {
        throw new IllegalArgumentException("Size must be more than 0");
      }
      if (args[2].length() > 1) {
        throw new IllegalArgumentException("Wrong symbol");
      }
      char s = args[2].charAt(0);
      if (args[3].length() > 1) {
        throw new IllegalArgumentException("Wrong symbol");
      }
      char c = args[3].charAt(0);
      BoxGenerator box = new BoxGenerator(w, h, s, c);
      box.draw();
    }
  }

  public BoxGenerator(int width, int height, char side, char corner) {
    this.side = side;
    this.corner = corner;
    this.width = width;
    strings = new String[height];
    for (int i = 0; i < height; i++) {
      strings[i] = "";
    }
    generate();
  }

  public void generate() {
    generateFirstLast();
    generateInside();
  }

  public void generateInside() {
    for (int i = 1; i < strings.length - 1; i++) {
      String str = String.format("%" + (width - 2) + "s", "");
      strings[i] = String.format("%1$s%2$s%1$s\n", side, str);
    }
  }

  public void generateFirstLast() {
    String str = (width < 3) ? "" : String.format("%" + (width - 2) + "s", "").replace(' ', side);
    strings[0] = (corner == '\u0000') && (side == '\u0000') ? "\n"
               : String.format("%1$c%2$s%1$c\n", corner, str);
    strings[strings.length - 1] =  strings[0];
  }

  public void draw() {
    for (int i = 0; i < strings.length; i++) {
      System.out.print(strings[i]);
    }
  }
}

