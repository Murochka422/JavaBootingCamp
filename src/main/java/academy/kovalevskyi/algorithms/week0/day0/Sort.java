package academy.kovalevskyi.algorithms.week0.day0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public interface Sort {
  default <T extends Comparable<? super T>> void sort(final T[] target) {
    sort(target, T::compareTo);
  }

  default <T> void sort(T[] target, final Comparator<T> comparator) {
  /*   T temp;
    for (int i = 0; i < target.length; i++) {
      boolean sorted = true;
      for (int j = 0; j < target.length - i - 1; j++) {
        if (comparator.compare(target[j], target[j + 1]) > 0) {
          sorted = false;
          temp = target[j];
          target[j] = target[j + 1];
          target[j + 1] = temp;
        }
      }
      if (sorted) {
        return;
      }
    }*/
    int n = target.length;
    IntStream.range(0, n - 1)
        .flatMap(i -> IntStream.range(1, n - i))
        .forEach(j -> {
          if (comparator.compare(target[j - 1], target[j]) > 0) {
            T temp = target[j];
            target[j] = target[j - 1];
            target[j - 1] = temp;
          }
        });
  }

  default <T> T[] createSortedArray(final T[] target, final Comparator<T> comparator) {
    T[] sortArray = Arrays.copyOf(target, target.length);
    sort(sortArray, comparator);
    return sortArray;
  }


  default String complexityBest() {
    return "N";
  }

  default String complexityAverage() {
    return "N^2";
  }

  default String complexityWorst() {
    return "N^2";
  }

  default String spaceComplexityWorst() {
    return "N";
  }
}
