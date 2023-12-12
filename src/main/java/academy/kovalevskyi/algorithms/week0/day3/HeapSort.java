package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class HeapSort implements Sort {

  public static void main(String[] args) {
    Sort sort = new HeapSort();
    Integer[] arr = {100, 500, 0, -80, -12, 48, -1, 101};
    sort.sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    int n = target.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heap(target, n, i, comparator);
    }
    for (int i = n - 1; i >= 0; i--) {
      swap(target, 0, i);
      heap(target, i, 0, comparator);
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

  private <T> void heap(T[] target, int n, int i, Comparator<T> comparator) {
    int max = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && comparator.compare(target[left], target[max]) > 0) {
      max = left;
    }
    if (right < n && comparator.compare(target[right], target[max]) > 0) {
      max = right;
    }
    if (max != i) {
      swap(target, i, max);
      heap(target, n, max, comparator);
    }
  }

  private  <T> void swap(T[] arr, int i, int j) {
    T temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
