ssssssssssssssssss eeeeeeeee bbbbbbbbbbbbbbbbbbb

Case 1: If input[M] < target ("s"): L = M + 1 // L = M ??? both ok
Case 2: If input[M] == target ("e"): L = M + 1 // L = M ??? both ok
Case 3: If input[M] > target ("b"): R = M // R = M - 1 ??? Wrong

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
      
      // Post processing
      if (array[l] > target) { // check a[left] against target first
          return l;
      }

      if (array[r] > target) { // check a[right] against target first
          return r;
      }

      return -1;
  }
}
