public class Solution {
  public int binarySearch(int[] array, int target) {
      if (array == null || array.length == 0) {
          return -1;
      }

      int l = 0;
      int r = array.length - 1;
      while (l <= r) { // l < r is WRONG, eg. a[] = {5} target = 5
        int m = l + (r - l) / 2;

        if (array[m] == target) {
            return m;
        } else if (array[m] < target) {
            l = m + 1; // l = m; ??? eg. a[] = {5} target = 8
                       //                      LMR = 0
        } else {
            r = m - 1;
        }
      }

      return -1;
  }
}
// Time = O(log n)
// Extra space = O(1)
