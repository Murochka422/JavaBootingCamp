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

  public StdString2(String s) {
    super(s.toCharArray());
  }

  public StdString2 toAsciiLowerCase() throws IllegalArgumentException {
    return new StdString2(StringUtils.makeLowercase(str).toString().toCharArray());
  }

  public StdString2 toAsciiUpperCase() throws IllegalArgumentException {
    return new StdString2(StringUtils.makeUppercase(str).toString().toCharArray());
  }

  public StdString2 subString(int from, int to) throws IllegalArgumentException {
    if (from > to) {
      throw new IllegalArgumentException("Not valid arguments");
    }
    char[] ch = new char[to - from];
    for (int i = 0; i < ch.length; i++) {
      ch[i] = charAt(i + from);
    }
    return new StdString2(ch);
  }

  public StdString2 concat(StdString2... that) {
    if (that == null) {
      return this;
    }
    if (that.length == 0) {
      return this;
    }
    char[][] strings = new char[that.length + 1][];
    strings[0] = this.toCharArray();
    for (int i = 1; i < strings.length; i++) {
      strings[i] = that[i - 1].toCharArray();
    }
    return new StdString2(StringUtils.concatStrings(strings));
  }

  public int indexOf(char target, int from) {
    for (int i = from; i < length(); i++) {
      if (str[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public StdString2[] split(char separator) {
    StdString2 patient = new StdString2(this);
    while (charAt(patient.length() - 1) == separator) {
      patient = patient.removeLast();
    }
    int amount = patient.containsAmount(separator);
    StdString2[] strings = new StdString2[amount + 1];
    int start = 0;
    int end = 0;
    int i = 0;
    while ((end = patient.indexOf(separator, start)) != -1) {
      strings[i] = patient.subString(start, end);
      start = end + 1;
      i++;
    }
    strings[i] = patient.subString(start, patient.length());
    return strings;
  }

  public StdString2 trim() {
    if (this.length() == 0) {
      return this;
    }
    int start = 0;
    int end = length();
    while ((start < end) & (StringUtils.isAsciiSpace(charAt(start)))) {
      start++;
    }
    while ((start < end) & (StringUtils.isAsciiSpace(charAt(end - 1)))) {
      end--;
    }
    return subString(start, end);
  }

  public StdString2 removeCharacter(char toRemove) {
    if (this.length() == 0) {
      return this;
    }
    StdString2[] sarr = this.split(toRemove);
    StdString2 s = new StdString2();
    return s.concat(sarr);
  }

  private int containsAmount(char ch) {
    int amount = 0;
    for (int i = 0; i < length(); i++) {
      if (charAt(i) == ch) {
        amount++;
      }
    }
    return amount;
  }

  private StdString2 removeFirst() {
    return new StdString2(subString(1, length()));
  }

  private StdString2 removeFirst(int amount) {
    return new StdString2(subString(amount, length()));
  }

  private StdString2 removeLast() {
    return new StdString2(subString(0, length() - 1));
  }
}
