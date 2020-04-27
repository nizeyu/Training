public class Solution {
  public int binarySearch(int[] array, int target) {
      if (array == null || array.length == 0) {
          return -1;
      }

      int left = 0;
      int right = array.length - 1;
      while (left <= right) { // l < r is WRONG, eg. a[] = {5} target = 5
        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            left = mid + 1; // l = m; ??? eg. a[] = {5} target = 8
                       //                      LMR = 0
        } else {
            right = mid - 1;
        }
      }

      return -1;
  }
}
// Time = O(log n)
// Extra space = O(1)
