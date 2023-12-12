package academy.kovalevskyi.algorithms.week0.day0;

import java.util.Arrays;
import java.util.Comparator;

public class Tasks {
  static Sort sort = new Sort() {};

  public static void main(String[] args) {
    String left = "abbb00";
    String r = "aabc1/";
    System.out.println(sameCharactersSorting(left, r));
    System.out.println(sameCharactersO1(left, r));
  }

  public static boolean sameCharactersSorting(String left, String right) {
    if (left.equals(right)) {
      return true;
    }
    if (left.length() != right.length()) {
      return false;
    }
    Integer[] leftArr = sort.createSortedArray(toArr(left), Comparator.naturalOrder());
    Integer[] rightArr = sort.createSortedArray(toArr(right), Comparator.naturalOrder());
    return Arrays.equals(leftArr, rightArr);
  }

  public static boolean sameCharactersO1(String left, String right) {
    if (left.equals(right)) {
      return true;
    }
    if (left.length() != right.length()) {
      return false;
    }
    return hash(left) == hash(right);
  }

  private static Integer[] toArr(String s) {
    return s.chars()
        .boxed()
        .toArray(Integer[]::new);
  }

  private static int hash(String s) {
    return s.chars()
        .map(num -> num*num*31)
        .sum();
  }
}