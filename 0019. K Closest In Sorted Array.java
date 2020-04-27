// Solution 1
public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0) {
      return array;
    }

    if (k == 0) {
      return new int[0];
    }

    // using binary search 
    int l = 0;
    int r = array.length - 1;
    while (l + 1 < r) {
      int m = l + (r - l) / 2;

      if (array[m] == target) {
          r = m;
      } else if (array[m] < target) {
          l = m;
      } else {
          r = m;
      }
    }
    // l, r should be the closest to target.

    int[] res = new int[k];
    // This is a typical merge operation.
    for (int i = 0; i < k; i++) {
      // we can advance the l pointer when:
      // 1. r pointer is already out of bound.
      // 2. r pointer is not out of bound, l pointer is not out of bound,
      //    and array[l] is closer to target.
      if (r >= array.length || l >= 0 && Math.abs(target - array[l]) <= Math.abs(target - array[r])) {
        res[i] = array[l--];
      } else {
        res[i] = array[r++];
      }
    }

    return res;
  }
}

Step 1: run binary search to find L and R  O(log n)
Step 2: 谁小移谁                            O(k)
Time = O(log n + k)
  
k ~~~~~~~~ n
500000    1000000


// My solution
public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
      int l = 0;
      int r = array.length - 1;
      while (l + 1 < r) {
          int m = l + (r - l) / 2;

          if (array[m] == target) {
              r = m;
          } else if (array[m] < target) {
              l = m;
          } else {
              r = m;
          }
      }
      int[] res = new int[k];
      int i = 0;
      while (l >= 0 && r < array.length && k > 0) {
         if (Math.abs(target - array[l]) <= Math.abs(target - array[r])) {
             res[i] = array[l];
             l--;
         } else {
             res[i] = array[r];
             r++;
         }
         i++;
         k--;
      }

      while (k > 0) {
          if (l >= 0) {
              res[i] = array[l];
              l--;
              i++;
          }

          if (r < array.length) {
              res[i] = array[r];
              r++;
              i++;
          }

          k--;
      }

      return res;
  }
}
