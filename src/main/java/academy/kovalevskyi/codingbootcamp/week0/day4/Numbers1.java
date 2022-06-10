package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Numbers1 {

  public static void main(String[] args) {
    System.out.println("-2147483648     " + numberLength(-2147483648));
    numbOut(convertToCharArray(-2147483648));
    
    
  }

  public static int[] generateNumbers() {
    int[] numbers = new int[100];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i;
    }
    return numbers;
  }

  public static int findBiggest(int left, int right) {
    if (left >= right) {
      return left;
    }
    return right;
  }

  public static int findBiggest(int left, int mid, int right) {
    return findBiggest(findBiggest(left, mid), right);
  }

  public static int findBiggest(int[] numbers) {
    int max = numbers[0];
    for (int i = 1; i < numbers.length; i++) {
      max = findBiggest(max, numbers[i]);
    }
    return max;
  }

  public static int findIndexOfBiggestNumber(int[] numbers) {
    int max = findBiggest(numbers);
    for (int i = 0; i < numbers.length; i++) {
      if (max == numbers[i]) {
        return i;
      }
    }
    return 0;
  }

  public static boolean isNegative(int number) {
    if (number < 0) {
      return true;
    }
    return false;
  }

  public static char[] convertToCharArray(int number) {
    char[] characters = new char[numberLength(number)];
    int numb = number;
    if (isNegative(number)) {
      characters[0] = '-';
      numb = numberAbs(number); 
    }
    int i = characters.length - 1;
    while (numb >= 10) {
      characters[i] = (char) (48 + (numb % 10));
      numb /= 10;
      i--;
    }
    characters[i] = (char) (48 + numb);
    if (isMin(number)) {
      characters[characters.length - 1] = (char) ((int) (characters[characters.length - 1] + 1));
    }
    return characters;
  }

  public static void convertToArray(int number) {
    int[] numbers = new int[numberLength(number)];
    int numb = number;
    if (isNegative(numb)) {
      numb = numberAbs(number); 
    }
    int i = numbers.length - 1;
    while (numb >= 10) {
      numbers[i] = numb % 10;
      numb /= 10;
      i--;
    } 
    numbers[i] = numb;
    if (isMin(number)) {
      numbers[numbers.length - 1] += 1;
    }
    for (i = 0; i < numbers.length; i++) {
      System.out.println(numbers[i]);
    }
  }

  public static void numbOut(char[] characters) {
    for (int i = 0; i < characters.length; i++) {
      System.out.println(characters[i]);
    }
  } 

  public static int numberLength(int number) {
    int length = 1;
    int numb = number;
    if (isNegative(number)) {
      length++;
      numb = numberAbs(number); 
    }
    while (numb >= 10) {
      length++;
      numb /= 10;
    }
    return length;
  }

  public static int numberAbs(int number) {
    if (isNegative(number) & isMin(number)) {
      return 0 - number - 1; 
    }
    if (isNegative(number)) {
      return 0 - number; 
    }
    return number;
  }

  public static boolean isMin(int number) {
    return (number == Integer.MIN_VALUE);
  }
}
