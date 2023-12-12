package academy.kovalevskyi.codingbootcamp.week2.day0;

public class MainPrintParam {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
    } else {
      for (String s : args) {
        System.out.println(s);
      }
    }
  }
}
