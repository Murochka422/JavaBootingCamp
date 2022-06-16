package academy.kovalevskyi.codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting<T> {

  public static <T> void sort(T[] target, Comparator<T> comparator) {
    T temp = target[0];
    for (int i = 0; i < target.length; i++) {
      for (int j = i; j < target.length; j++) {
        if (comparator.compare(target[i], target[j]) > 0) {
          temp = target[i];
          target[i] = target[j];
          target[j] = temp;
        }
      }
    }
  }

  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
    sort(target, comparator.reversed());
  }
} 
