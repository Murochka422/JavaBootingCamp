package academy.kovalevskyi.codingbootcamp.week1.day0;

import academy.kovalevskyi.codingbootcamp.week0.day4.Numbers1;

public class NumberUtils {

  public static void main(String[] args) {
    System.out.println("sqrt 10  " + sqrt(10));
    System.out.println("sqrt 625  " + sqrt(625));
    System.out.println("sqrt 102548  " + sqrt(102548));
    System.out.println("sqrt 731025  " + sqrt(731025));
  }

  public static long getFactorial(final int number) throws IllegalArgumentException {
    if ((number < 0) | (number > 20)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    if (number == 0) {
      return 1;
    }
    long fact = 1L;
    for (int i = 2; i <= number; i++) {
      fact = fact * i;
    }
    return (long) fact;
  } 

  public static long factorialRecursive(int number) throws IllegalArgumentException {
    if ((number < 0) | (number > 20)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    if (number == 0) {
      return 1;
    }
    return (long) (number * factorialRecursive(number - 1));
  } 

  static final int safeMultiply(int a, int b) throws ArithmeticException {
    long result = a * b;    
    if (a != result / b) {
      throw new ArithmeticException("Integer overflow");
    }
    return a * b;
  }

  public static double power(int base, int power) throws IllegalArgumentException {
    if (power == 0) {
      return 1;
    }
    double result = 1D;
    for (int i = 1; i <= Numbers1.numberAbs(power); i++) {
      result = result * (double) base;
    }
    if (power < 0) {
      return 1 / (double) result;
    }
    return (double) result;
  } 

  public static double powerRecursive(int base, int power) throws IllegalArgumentException {
    if (power == 0) {
      return 1;
    }
    if (power > 0) {
      return (double) (base * powerRecursive(base, power - 1));
    }
    return (double) (1 / (base * powerRecursive(base, Numbers1.numberAbs(power) - 1)));
  }

  public static int fibRecursive(int index) throws IllegalArgumentException {
    if (index < 0) {
      throw new IllegalArgumentException("Not valid argument");
    }
    if (index > 1) {
      return fibRecursive(index - 1) + fibRecursive(index - 2); 
    }
    if ((index == 0) | (index == 1)) {
      return index;
    } 
    return -1;
  }

  public static int[] fibSequence(int length) throws IllegalArgumentException {
    if (length < 0) {
      throw new IllegalArgumentException("Not valid argument");
    }
    int[] arr = new int[length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = fibRecursive(i);
    }
    return arr;
  }

  public static int sqrtAll(int target) throws IllegalArgumentException {
    if (Numbers1.isNegative(target)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    long sqrt = target;
    while (sqrt * sqrt > target) {
      sqrt = (long) (0.5 * (sqrt + target / sqrt));
    }
    return (int) sqrt;
  }

  public static int sqrt(int target) throws IllegalArgumentException {
    if (Numbers1.isNegative(target)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    long sqrt = target;
    while (sqrt * sqrt > target) {
      sqrt = (long) (0.5 * (sqrt + target / sqrt));
    }
    if (powerRecursive((int) sqrt, 2) == target) {
      return (int) sqrt;
    }
    return -1;
  }

  public static boolean isPrime(int target) throws IllegalArgumentException {
    if (Numbers1.isNegative(target)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    if (target <= 1) {
      return false;
    }
    if (target <= 3) {
      return true;
    }
    int i = 2;
    while (i <= sqrtAll(target)) {
      if (isDivided(target, i)) {
        return false;
      }
      i++;
    }  
    return true;
  }

  public static int findNextPrime(int target) throws IllegalArgumentException {
    if (Numbers1.isNegative(target)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    int temp = target;
    while (true) {
      if (isPrime(temp)) {
        return temp;
      }
      temp++;
    }
  }

  public static boolean isDivided(int a, int b) {
    return (a % b) == 0;
  }

  public static void sort(int[] target) {
    if (target != null) {   
      int temp;
      for (int i = 0; i < target.length; i++) {
        for (int j = i; j < target.length; j++) {
          if (target[i] > target[j]) {
            temp = target[i];
            target[i] = target[j];
            target[j] = temp;    
          }
        }   
      }  
    }
  }
}
