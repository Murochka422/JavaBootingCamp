package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.stream.IntStream;

public class StringUtils {
 
  public static boolean isAsciiChar(char ch) throws IllegalArgumentException {
    if ((ch < 0) || (ch > 255)) {
      throw new IllegalArgumentException("Not valid argument");
    }
    return true;
  }

  public static boolean isAsciiUppercase(char ch) throws IllegalArgumentException {
    if (isAsciiChar(ch)) {
      if ((ch >= 'A') && (ch <= 'Z')) {
        return true;
      } 
    }
    return false;
  }

  public static boolean isAsciiLowercase(char ch) throws IllegalArgumentException {
    if (isAsciiChar(ch)) {
      if ((ch >= 'a') && (ch <= 'z')) {
        return true;
      } 
    }
    return false;
  }

  public static boolean isAsciiNumeric(char ch) throws IllegalArgumentException {
    if (isAsciiChar(ch)) {
      if ((ch >= '0') && (ch <= '9')) {
        return true;
      } 
    }
    return false;
  }

  public static boolean isAsciiSpace(char ch) throws IllegalArgumentException {
    if (isAsciiChar(ch)) {
      if (ch <= ' ') {
        return true;
      } 
    }
    return false;
  }

  public static boolean isAsciiMinus(char ch) throws IllegalArgumentException {
    if (isAsciiChar(ch)) {
      if (ch <= '-') {
        return true;
      } 
    }
    return false;
  }

  public static boolean isAsciiAlphabetic(char ch) throws IllegalArgumentException {
    return isAsciiUppercase(ch) || isAsciiLowercase(ch);
  }

  public static boolean isStringAlphaNumerical(char[] input) throws IllegalArgumentException {
    for (int i = 0; i < input.length; i++) {
      if ((!isAsciiAlphabetic(input[i])) && (!isAsciiNumeric(input[i])) 
                                         && (!isAsciiSpace(input[i]))) {
        return false;
      }
    }
    return true;
  }

  public static char toAsciiUppercase(char ch) throws IllegalArgumentException {
    if (isAsciiLowercase(ch)) {
      return (char) ((int) ch - 32); 
    }
    return ch;
  }

  public static char toAsciiLowercase(char ch) throws IllegalArgumentException {
    if (isAsciiUppercase(ch)) {
      return (char) ((int) ch + 32); 
    }
    return ch;
  }

  public static StringBuilder makeUppercase(char[] input) throws IllegalArgumentException {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      str.append(toAsciiUppercase(input[i]));
    }
    return str;
  }

  public static StringBuilder makeLowercase(char[] input) throws IllegalArgumentException {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      str.append(toAsciiLowercase(input[i]));
    }
    return str;
  }

  public static StringBuilder makeCamel(char[] input) throws IllegalArgumentException {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < input.length - 1; i += 2) {
      str.append(toAsciiLowercase(input[i]));
      str.append(toAsciiUppercase(input[i + 1]));
    }
    if (input.length % 2 != 0) {
      str.append(toAsciiLowercase(input[input.length - 1]));
    } 
    return str;
  }

  public static char[] concatStrings(char[]... input) throws IllegalArgumentException {
    int l = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        if (isAsciiChar(input[i][j])) {
          continue;
        }
      }
      l += input[i].length;
    }
    char[] str = new char[l];
    l = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        str[l] = input[i][j];
        l++;
      }
    }
    return str;
  }

  public static int toInt(char[] input) throws IllegalArgumentException, NumberFormatException,
                                               NullPointerException {
    if (input == null) {
      throw new NullPointerException("Array is null");
    }
    if (input.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }
    if (!(isAsciiNumeric(input[0]) || (isAsciiMinus(input[0]) && input.length > 1))) {
      throw new NumberFormatException("Not valid number format");
    }
    for (int i = 1; i < input.length; i++) {
      if (!(isAsciiNumeric(input[i]))) {
        throw new NumberFormatException("Not valid number format");
      }
    }
    int k = 0;
    if (isAsciiMinus(input[0])) {
      k++;
    }    
    int number = 0;
    for (int i = k; i < input.length - 1; i++) {
      number += (int) input[i] - 48;
      number *= 10;
    } 
    number += (int) input[input.length - 1] - 48;
    if (isAsciiMinus(input[0])) {
      number *= -1;
    }    
    return number;
  }
}
