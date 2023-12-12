package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week1.day1.Sorting;


public class MainPrintSortedParam {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify at least one argument!");
    } else {
      Sorting.sort(args, String::compareTo);
      MainPrintParam.main(args);
    }
  }
}
