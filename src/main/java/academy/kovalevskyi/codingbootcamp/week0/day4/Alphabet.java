package academy.kovalevskyi.codingbootcamp.week0.day4;

public class Alphabet {

  public static char[] generateAlphabet() {
    char[] alphabet = new char[26];
    alphabet[0] = 'a';
    for (int i = 1; i < alphabet.length; i++) {
      alphabet[i] = (char) ((int) alphabet[i - 1] + 1);
    }
    return alphabet;
  }

  public static char[] generateReversedAlphabet() {
    char[] alphabet = new char[26];
    alphabet[0] = 'z';
    for (int i = 1; i < alphabet.length; i++) {
      alphabet[i] = (char) ((int) alphabet[i - 1] - 1);
    }
    return alphabet;
  }
}
