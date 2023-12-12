package academy.kovalevskyi.algorithms.week0.day2;

import java.util.OptionalInt;

public class Tasks {

  public static void main(String[] args) {
    int[] arr = {-1, 0, 1, 5, 6, 100, 188, 189, 190, 200};
    System.out.println(findIndex(arr, 1));
  }


  public static OptionalInt findIndex(int[] sortedArray, int target) {
    int start = 0;
    int end = sortedArray.length - start - 1;
    int i = end / 2;
    while (start <= end) {
      if (sortedArray[i] == target) {
        return OptionalInt.of(i);
      }
      if (sortedArray[i] < target) {
        start = i + 1;
      } else {
        end = i - 1;
      }
      i = ((end - start) / 2) + start;
    }
    return OptionalInt.empty();
  }
}
