package academy.kovalevskyi.algorithms.week0.day2;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    int size = 1;
    T[] temp = Arrays.copyOf(target, target.length);
    while (size < target.length) {
      for (int i = 0; i < target.length; i += size * 2) {
        merge(target, i, temp, size, comparator);
      }
      size *= 2;
      for (int i = 0; i < target.length; i++) {
        target[i] = temp[i];
      }
    }
  }

  @Override
  public String complexityBest() {
    return "N*log(N)";
  }

  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  @Override
  public String complexityWorst() {
    return "N*log(N)";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N";
  }

  private <T> void merge(T[] src, int index1, T[] result, int size, Comparator<T> comparator) {
    int index2 = index1 + size;
    int startResult = index1;

    int endFirst = index1 + size < src.length ? index1 + size : src.length;
    int endSecond = index2 + size < src.length ? index2 + size : src.length;

    int iteration = endFirst - index1 + endSecond - index2;

    for (int i = startResult; i < startResult + iteration; i++) {
      if (index1 < endFirst && (index2 >= endSecond
                   || (comparator.compare(src[index1], src[index2]) < 0))) {
        result[i] = src[index1];
        index1++;
      } else {
        result[i] = src[index2];
        index2++;
      }
    }
  }
}
