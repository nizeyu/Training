public class Solution {
  public int closest(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int left = 0;
      int right = array.length - 1;
      while (left + 1 < right) { // l neighbors r -> terminate
          int mid = left + (right - left) / 2;

          if (array[mid] == target) {
              return mid;
          } else if (array[mid] < target) {
              left = mid; // left = mid + 1 wrong
              1 2 3 8 9 target = 4
              L   M   R
                    L R
            
              严格递减：index = 0 1 2
                      L M R
                        L R
          } else {
              right = mid; // right = mid - 1 wrong
          }
      }
      
      // Post-processing
      // check a[l] against target first
      return Math.abs(target - array[left]) <= Math.abs(target - array[right]) ? left : right;
  }
}
  


