package academy.kovalevskyi.codingbootcamp.week2.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;
import academy.kovalevskyi.codingbootcamp.week1.day0.NumberUtils;

public class Numbers2 extends Numbers1 {

  public static char[][] generateTriplets() {
    final var amount = 3;
    char[][] numbers = new char[amountCombNoRepeat(amount, 10)][amount];
    //first triple
    numbers[0] = fillTriple(new char[]{'0', '0', '0'}, '0', 0);

    //another triples
    for (int i = 1; i < numbers.length; i++) {
      copyOf(numbers[i - 1], numbers[i]);
      for (int j = 2; j >= 0; j--) {
        if (numbers[i][j] < ('7' + j)) {
          numbers[i] = fillTriple(numbers[i], (char) (numbers[i][j] + 1), j);
          break;
        }
      }
    }
    return numbers;
  }

  public static char[][] generateTuples() {
    char[][] temp = generateTuples(4);
    char[][] numbers = new char[temp.length][5];
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < 2; j++) {
        numbers[i][j] = temp[i][j];
      }
      numbers[i][2] = ' ';
      for (int j = 3; j < numbers[0].length; j++) {
        numbers[i][j] = temp[i][j - 1];
      }
    }
    return numbers;
  }

  public static char[][] generateTuples(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("amount might be more positive");
    }
    if (amount == 0) {
      return new char[0][];
    }
    char[][] numbers = new char[amountCombRepeat(amount, 10)][amount];
    //first tuple
    for (int j = 0; j < amount; j++) {
      numbers[0][j] = '0';
    }
    //another tuples
    for (int i = 1; i < numbers.length; i++) {
      copyOf(numbers[i - 1], numbers[i]);
      for (int j = amount - 1; j >= 0; j--) {
        if (numbers[i][j] < '9') {
          numbers[i] = fillTuple(numbers[i], (char) (numbers[i][j] + 1), j);
          break;
        }
      }

    }
    return numbers;
  }

  private static int amountCombNoRepeat(int m, int n) {
    long c = NumberUtils.factorialRecursive(n) / (NumberUtils.factorialRecursive(m)
        * NumberUtils.factorialRecursive(n - m));
    return (int) c;
  }

  private static int amountCombRepeat(int m, int n) {
    return (int) NumberUtils.powerRecursive(n, m);
  }

  private static char[] fillTriple(char[] base, char start, int index) {
    char[] triple = new char[base.length];
    copyOf(base, triple);
    for (int i = index; i < triple.length; i++, start++) {
      triple[i] = start;
    }
    return triple;
  }

  private static char[] fillTuple(char[] base, char start, int index) {
    char[] triple = new char[base.length];
    copyOf(base, triple);
    triple[index] = start;
    for (int i = index + 1; i < triple.length; i++) {
      triple[i] = '0';
    }
    return triple;
  }

  private static void copyOf(char[] a, char[] b) {
    for (int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }
  }

  private static void output(char[][] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(i + "  ");
      for (int j = 0; j < numbers[0].length; j++) {
        System.out.print(numbers[i][j]);
      }
      System.out.println();
    }
  }
}
