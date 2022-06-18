package academy.kovalevskyi.codingbootcamp.week1.day4;

import academy.kovalevskyi.codingbootcamp.week1.day2.StdString1;
import academy.kovalevskyi.codingbootcamp.week1.day2.StringUtils;

public class StdString2 extends StdString1 {

  public StdString2(char[] base) {
    super(base);
  }
  public StdString2() {
    super();
  }
  public StdString2(StdString2 that) {
    super(that);
  }

  public StdString2 toAsciiLowerCase() throws IllegalArgumentException{
    return new StdString2(StringUtils.makeLowercase(str).toString().toCharArray());
  }

  public StdString2 toAsciiUpperCase() throws IllegalArgumentException{
    return new StdString2(StringUtils.makeUppercase(str).toString().toCharArray());
  }

  public StdString2 subString(int from, int to) {
    if (from <= to) {
      char[] ch = new char[to - from];
      for (int i = 0; i < ch.length; i++) {
        ch[i] = charAt(i + from);
      }
      return new StdString2(ch);
    }
    return this;
  }

  public StdString2 concat(StdString2... that) {
    char[][] strings = new char[that.length][];
    for (int i = 0; i< strings.length; i++) {
      strings[i] = that[i].str;
    }
    return new StdString2(StringUtils.concatStrings(strings));
  }

  public int containsAmount(char ch) {
    int amount = 0;
    for (int i = 0; i < length(); i++) {
      if (charAt(i) == ch) {
        amount++;
      }
    }
    return amount;
  }
  
  public StdString2 removeFirst() {
    return new StdString2(subString(1, length()));
  }

  public StdString2 removeFirst(int amount) {
    return new StdString2(subString(amount, length()));
  }

  public StdString2 removeLast() {
    return new StdString2(subString(0, length() - 1));
  }

  /*  public StdString2[] split(char separator) {
    StdString2 patient = new StdString2(this);
    int amount = patient.containsAmount(separator);
    if (charAt(0) == separator) {
      amount--;
    }
    if (charAt(length() - 1) == separator) {
      amount--;
    }
    StdString2[] strings = new StdString2[amount + 1];
    for (int i = 0; i < strings.length; i++) {
      strings[i] = patient.subString(0, patient.indexOf(separator));
      patient = patient.removeFirst(strings[i].length() + 1);
    }
    return strings;
  }*/

  public StdString2[] split(char separator) {
    StdString2 patient = new StdString2(this);
    int amount = patient.containsAmount(separator);
    StdString2[] strings = new StdString2[amount + 1];
    for (int i = 0; i < strings.length; i++) {
      strings[i] = patient.subString(0, patient.indexOf(separator));
      patient = patient.removeFirst(strings[i].length() + 1);
    }
    return strings;
  }

  public StdString2 trim() {
    char[] spaces = {' ', '\n', '\t'};
    StdString2 patient = new StdString2(this);
    for (char ch: spaces) {
      patient.trimCharacter(ch);
    }
    return patient;
  }

  public StdString2 trimCharacter(char ch) {
    if (length() == 0) {
      return this;
    }
    StdString2 patient = new StdString2(this);   
    while (patient.charAt(0) == ch) {
      patient = patient.removeFirst();
    }
    while (patient.charAt(patient.length() - 1) == ch) {
      patient = patient.removeLast();
    }
    return patient;
  }

  public StdString2 removeCharacter(char toRemove) {
    return new StdString2(concat(split(toRemove)));
  }
}
