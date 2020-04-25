public class Solution {
  public int binarySearch(int[] array, int target) {
      if (array == null || array.length == 0) {
          return -1;
      }

      int l = 0;
      int r = array.length - 1;
      while (l <= r) {
        int m = l + (r - l) / 2;

        if (array[m] == target) {
            return m;
        } else if (array[m] < target) {
            l = m + 1;
        } else {
            r = m - 1;
        }
      }

      return -1;
  }
}
