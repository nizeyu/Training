public class Solution {
  public int closest(int[] array, int target) {
      if (array == null || array.length == 0) {
          return - 1;
      }

      int l = 0;
      int r = array.length - 1;
      while (l + 1 < r) { // l neighbors r -> terminate
          int m = l + (r - l) / 2;

          if (array[m] == target) {
              return m;
          } else if (array[m] < target) {
              l = m; // l = m + 1 wrong
              1 2 3 8 9 target = 4
              L   M   R
                    L R
            
              严格递减：index = 0 1 2
                      L M R
                        L R
          } else {
              r = m; // r = m - 1 wrong
          }
      }
      
      // Post-processing
      // check a[l] against target first
      return Math.abs(target - array[l]) <= Math.abs(target - array[r]) ? l : r;
  }
}
Step 1: run binary search to find L and R  O(log n)
Step 2: 谁小移谁                            O(k)
Time = O(log n + k)
  
k ~~~~~~~~ n
500000    1000000
  


