public class Solution {
  public int largestSum(int[] array) {
    if (array.length == 1) {
      return array[0];
    }

    int max = array[0];
    int sum = array[0];
    for (int i = 1; i < array.length; i++) {
      sum = Math.max(sum + array[i], array[i]);
      max = Math.max(max, sum);
    }

    return max;
  }
}
