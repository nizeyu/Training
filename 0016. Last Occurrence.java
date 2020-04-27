public class Solution {
  public int lastOccur(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int left = 0;
      int right = array.length - 1;
      while (left + 1 < right) { // if l neighbors r -> terminate
          int mid = left + (right - left) / 2;

          if (array[mid] == target) {
              left = mid; // do not stop here, keep checking to right
          } else if (array[mid] < target ) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }

      if (array[right] == target) {
          return right;
      }

      if (array[left] == target) {
          return left;
      }

      return -1;
  }
}
