package academy.kovalevskyi.codingbootcamp.week1.day2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;


public class StdString1  implements Iterable<Character> {
  protected char[] str;

  public StdString1(char[] base) {
    str = new char[base.length];
    copyOf(base);
  }

  public StdString1() {
    str = new char[0];
  }

  public StdString1(int l) {
    str = new char[l];
  }

  public StdString1(StdString1 stdString1) {
    str = new char[stdString1.length()];
    copyOf(stdString1.toCharArray());
  }

  private boolean equalStdStrings(StdString1 that) {
    if (length() != that.length()) {
      return false;
    }
    for (int i = 0; i < length(); i++) {
      if (str[i] != that.toCharArray()[i]) {
        return false;
      }
    }
    return true;
  }

  protected void copyOf(char[] base) {
    for (int i = 0; i < base.length; i++) {
      str[i] = base[i];
    }
  }

  protected void copyOf(char[] base, int point) {
    for (int i = point; i < (point + base.length); i++) {
      str[i] = base[i - point];
    }
  }

  public char[] toCharArray() {
    return str;
  }

  public int length() {
    return str.length;
  }
 
  public StdString1 append(StdString1 that) {
    StdString1 newStr = new StdString1(length() + that.length());
    newStr.copyOf(str, 0);
    newStr.copyOf(that.toCharArray(), length());
    return newStr;
  }

  public char charAt(int index) {
    return str[index];
  }

  public int indexOf(char target) {
    for (int i = 0; i < length(); i++) {
      if (str[i] == target) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean equals(final Object otherObj) {
    if (otherObj == this) {
      return true;
    }
    if (otherObj == null) {
      return false;
    }
    if (otherObj.getClass() != this.getClass()) {
      return false;
    }
    return equalStdStrings((StdString1) otherObj);
  }

  @Override
  public int hashCode() {
    int number = 0;
    for (int i = 0; i < length(); i++) {
      number += (int) str[i];
    }
    return number;
  }

  @Override
  public String toString() {
    return new String(str);
  }

  @Override
  public Iterator<Character> iterator() throws NoSuchElementException {
    return new Iterator<Character>() {
      private int index;      

      @Override
      public Character next() throws NoSuchElementException {
        if (!hasNext()) {
          throw new NoSuchElementException("No element");
        }
        return charAt(index++);
      }

      @Override
      public boolean hasNext() {
        return index < length();
      }
    };
  }
  
  @Override
  public void forEach(final Consumer<? super Character> action) {
    for (int i = 0; i < length(); i++) {
      action.accept(str[i]);
    }
  }
}
