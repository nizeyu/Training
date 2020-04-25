public class Solution {
  public int smallestElementLargerThanTarget(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int l = 0;
      int r = array.length - 1;
      while (l + 1 < r) {
          int m = l + (r - l) / 2;

          if (array[m] == target) {
              l = m + 1;
          } else if (array[m] < target) {
              l = m + 1;
          } else {
              r = m;
          }
      }

      if (array[l] > target) {
          return l;
      }

      if (array[r] > target) {
          return r;
      }

      return -1;
  }
}
