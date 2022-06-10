package academy.kovalevskyi.codingbootcamp.week0.day3;

public class JavaEntryChallenge {

  public static void main(String[] args) {
    
    System.out.println("Demo of sumOfTwoNumbers(100, 200)");
    System.out.println(sumOfTwoNumbers(100, 200));
    System.out.println("Demo of convertMinToSec(100)");
    System.out.println(convertMinToSec(100));
    System.out.println("Demo of compareTwoNumbers(100, 200)");
    compareTwoNumbers(100, 200);
    System.out.println("Demo of concatTwoStrings('Boris, 'Jonson')");
    concatTwoStrings("Boris", "Jonson");
    System.out.println("Demo of remainder(45, 10))");
    System.out.println(remainder(45, 10));
    System.out.println(sumOfTwoNumbers(100, 200));
    System.out.println(sumOfTwoNumbers(100, 200));
    System.out.println(sumOfTwoNumbers(100, 200));
    System.out.println(sumOfTwoNumbers(100, 200));
  }

  public static int sumOfTwoNumbers(int a, int b) {
    return a + b;
  }

  public static int convertMinToSec(int minutes) {
    return minutes * 60;
  }

  public static void compareTwoNumbers(int a, int b) {
    if (a > b) {
      System.out.print("Result: a is bigger");
    } else if (a < b) { 
      System.out.print("Result: b is bigger");
    } else {
      System.out.print("Result: numbers are equal");
    }
  }

  public static void concatTwoStrings(String firstName, String lastName) {
    System.out.print(firstName + " " + lastName);
  }

  public static int remainder(int a, int b) {
    return a % b;
  }

  public static boolean divisibleBy5(int num) {
    if ((num % 5) > 0) {
      return false;
    }
    return true;
  }

  public static int firstElementOfArray(int[] arr) {
    return arr[0];
  }

  public static int smallestElementOfArray(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return min;
  }
  
  public static void checkResultOfWork(boolean quick, boolean efficient, boolean reliable) {
    
    if (quick & efficient & reliable) {
      System.out.print("Result of work: excellent, but you are dreaming");
      return;
    }
    if (!quick & efficient & reliable) {
      System.out.print("Result of work: good, but tired of waiting");
      return;
    }
    if (quick & efficient & !reliable) {
      System.out.print("Result of work: excellent, but pricey");
      return;
    }
    if (quick & !efficient & reliable) {
      System.out.print("Result of work: poor, but fast enough");
      return;
    }
    System.out.print("Pick at least two");
  }
}

