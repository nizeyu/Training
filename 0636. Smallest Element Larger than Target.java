ssssssssssssssssss eeeeeeeee bbbbbbbbbbbbbbbbbbb

Case 1: If input[M] < target ("s"): L = M + 1 // L = M ??? both ok
Case 2: If input[M] == target ("e"): L = M + 1 // L = M ??? both ok
Case 3: If input[M] > target ("b"): R = M // R = M - 1 ??? Wrong

public class Solution {
  public int smallestElementLargerThanTarget(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int left = 0;
      int right = array.length - 1;
      while (left + 1 < right) {
          int mid = left + (right - left) / 2;

          if (array[mid] == target) {
              left = mid + 1;
          } else if (array[mid] < target) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      
      // Post processing
      if (array[left] > target) { // check a[left] against target first
          return left;
      }

      if (array[right] > target) { // check a[right] against target first
          return right;
      }

      return -1;
  }
}
