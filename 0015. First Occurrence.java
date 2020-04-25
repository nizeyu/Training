public class Solution {
  public int firstOccur(int[] array, int target) {
      if (array == null || array.length == 0) {
        return - 1;
      }

      int l = 0;
      int r = array.length - 1;
      // We need to use l + 1 < r here to make sure there is no infinite loop.
      // Think about the case when l + 1 == r,
      // when mid = l, it will be possible picking [mid, right] for the next round
      // and it will go into an infinite loop in that case.
      while (l + 1 < r) {
        int m = l + (r - l) / 2;

        if (array[m] == target) {
            r = m;
        } else if (array[m] < target) {
            l = m + 1;
        } else {
            r = m - 1;
        }
      }
      
      // Make sure you understand all the possible situation when entering
      // this postprocessing procedure.
      // 1. array has only 1 element.
      // 2. array has only 2 element.
      // 3. l + 1 == r and l is the result.
      // 4. l + 1 == r and r is the result.
      // 5. l + 1 == r and none of l, r is the result.
      if (array[l] == target) {
        return l;
      }

      if (array[r] == target) {
        return r;
      }

      return -1;
  }
}
