package academy.kovalevskyi.codingbootcamp.week2.day1;

public class TextPrinter1 {
  String text;

  public static void main(String[] args) throws IllegalArgumentException {
    if (args.length != 1) {
      System.out.printf("pLeAsE PrOvIdE OnLy oNe iNpUt aRgUmEnT, cUrReNt aMoUnT: %d", args.length);
    } else {
      String text = args[0];
      String str1 = "#".repeat(text.length() + 2);
      System.out.printf("""
          /%1$s\\
          %2$s %3$s %2$s 
          \\%1$s/\n""",
          str1, "#", text);
    }
  }
}


