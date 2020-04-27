/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null) {
      return -1;
    }
    
    int left = 0;
    int right = 1;
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right *= 2;
    }

    return binarySearch(dict, target, left, right);
    
  }

  private int binarySearch(Dictionary dict, int target, int left, int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (dict.get(mid) == null) {
        right = mid - 1;
        continue;
      }

      if (dict.get(mid) == target) {
        return mid;
      } else if (dict.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}

// My solution
/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null) {
      return -1;
    }

    int l = 0;
    int r = 1;
    // find the right boundary for binary search
    // extends until we are sure the target is within the [l, r] range.
    while (dict.get(r) != null && dict.get(r) < target) {
      // 1. move l to r
      // 2. double r index
      l = r;
      r = 2 * r;
    }

    return binarySearch(dict, target, l, r);
  }

  private int binarySearch(Dictionary dict, int target, int l, int r) {
    // classical binary search
    while (l <= r) {
      int m = l + (r - l) / 2;

      if (dict.get(m) == null) {
        r = m - 1;
        continue;
      }

      if (dict.get(m) == target) {
          return m;
      } else if (dict.get(m) < target) {
          l = m + 1;
      } else {
          r = m - 1;
      }
    }
    return -1;
  }
}
