public class Solution {
  public int lastOccur(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int l = 0;
      int r = array.length - 1;
      while (l + 1 < r) { // if l neighbors r -> terminate
          int m = l + (r - l) / 2;

          if (array[m] == target) {
              l = m; // do not stop here, keep checking to right
          } else if (array[m] < target ) {
              l = m + 1;
          } else {
              r = m - 1;
          }
      }

      if (array[r] == target) {
          return r;
      }

      if (array[l] == target) {
          return l;
      }

      return -1;
  }
}
