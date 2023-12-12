package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class QuickSort implements Sort {

  public static void main(String[] args) {
    Sort sort = new QuickSort();
    Integer[] arr = {-12, 0, -6, 8, 12};
    sort.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    int start = 0;
    int end = target.length - 1;
    quick(target, start, end, comparator);
  }

  @Override
  public String complexityBest() {
    return "N*log(N)";
  }

  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  private <T> void quick(T[] target, int start, int end, Comparator<T> comparator) {
    int index = start;
    int left = start + 1;
    int right = end;

    while (left <= right) {
      while (left < target.length && comparator.compare(target[left], target[index]) < 0) {
        left++;
      }
      while (right > 0 && comparator.compare(target[right], target[index]) >= 0) {
        right--;
      }
      if (left < right) {
        swap(target, left, right);
      }
    }
    if (index < right) {
      swap(target, index, right);
    }
    if (left - start > 1) {
      quick(target, start, right - 1, comparator);
    }
    if (end - right > 1) {
      quick(target, left, end, comparator);
    }
  }

  private  <T> void swap(T[] arr, int i, int j) {
    T temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}