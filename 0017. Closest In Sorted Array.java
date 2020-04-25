public class Solution {
  public int closest(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int l = 0;
      int r = array.length - 1;
      while (l + 1 < r) {
          int m = l + (r - l) / 2;

          if (array[m] == target) {
              return m;
          } else if (array[m] < target) {
              l = m;
          } else {
              r = m;
          }
      }

      return Math.abs(target - array[l]) <= Math.abs(target - array[r]) ? l : r;
  }
}
