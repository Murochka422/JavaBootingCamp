package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {

  public static int[] generateNumbers() {
    return generateAnyNumbers(100);
  }

  private static int[] generateAnyNumbers(int amount) {
    int[] numbers = new int[amount];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i;
    }
    return numbers;
  }

  public static int findBiggest(int left, int right) {
    return (left >= right) ? left : right;
  }

  public static int findBiggest(int left, int mid, int right) {
    return findBiggest(findBiggest(left, mid), right);
  }

  public static int findBiggest(int[] numbers) {
    return numbers[findIndexOfBiggestNumber(numbers)];
  }

  public static int findIndexOfBiggestNumber(int[] numbers) {
    int max = numbers[0];
    int index = 0;
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > max) {
        max = numbers[i];
        index = i;
      }
    }
    return index;
  }

  public static boolean isNegative(int number) {
    return number < 0;
  }

  public static char[] convertToCharArray(int number) {
    char[] characters = new char[numberLength(number)];
    int numb = number;
    int k = 1;
    if (isNegative(number)) {
      characters[0] = '-';
      characters[characters.length - 1] = (char) (48 - (numb % 10));
      numb /= -10;
      k++;
    }
    int i = characters.length - k;
    while (numb >= 10) {
      characters[i] = (char) (48 + (numb % 10));
      numb /= 10;
      i--;
    }
    characters[i] = (numb >= 1) || (number == 0) ? (char) (48 + numb) : characters[i];
    return characters;
  }

  static int numberLength(int number) {
    int length = 1;
    int numb = number;
    if (isNegative(number)) {
      length++;
      if ((numb /= -10) >= 1) {
        length++;
      }
    }
    while (numb >= 10) {
      length++;
      numb /= 10;
    }
    return length;
  }

  public static int numberAbs(int number) {
    return isNegative(number) ? number * -1 : number;
  }
}
