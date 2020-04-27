public class Solution {
  public int firstOccur(int[] array, int target) {
      if (array == null || array.length == 0) {
        return - 1;
      }

      int left = 0;
      int right = array.length - 1;
      // We need to use l + 1 < r here to make sure there is no infinite loop.
      // Think about the case when l + 1 == r,
      // when mid = l, it will be possible picking [mid, right] for the next round
      // and it will go into an infinite loop in that case.
      // Termination condition: 当L和R 相邻的时候，跳出while 循环，再判断L和R究竟哪个是最终答案（= post - processing）
      while (left + 1 < right) { // if l neighbors r -> terminate
        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            right = mid; // right = mid - 1 wrong   
                   // do not stop here, keep checking to left
                    3 4 5 5 5
                    L   M   R
                    L R  
                      
        } else if (array[mid] < target) {
            left = mid + 1; // left = mid both ok
            ... 4 5 5 5 5 5 5
                M           R
                  L         R     
          
        } else {
            right = mid - 1; // right = mid both ok
        }
      }
      
      // Make sure you understand all the possible situation when entering
      // this postprocessing procedure.
      // 1. array has only 1 element.
      // 2. array has only 2 element.
      // 3. l + 1 == r and l is the result.
      // 4. l + 1 == r and r is the result.
      // 5. l + 1 == r and none of l, r is the result.
      if (array[left] == target) {
        return left;
      }

      if (array[right] == target) {
        return right;
      }

      return -1;
  }
}
