public class Solution {
  public int[] search(int[][] matrix, int target) {
      if (matrix == null || matrix.length == 0 ) {
          return new int[]{-1, -1};
      }
      
      if (matrix[0] == null || matrix[0].length == 0) {
          return new int[]{-1, -1};
      }
      
      int m = matrix.length;
      int n = matrix[0].length;
      
      int left = 0;
      int right = m * n - 1;
      while(left <= right) {
          int mid = left + (right - left) / 2;
          int num = matrix[mid/n][mid%n]; // map 2D coordinate to 1D coordinate
          
          if (num == target) {
              return new int[]{mid/n, mid%n};
          } else if (num < target) {
              left = mid + 1;;
          } else {
              right = mid - 1;
          }
      }
      
      return new int[]{-1, -1};
  }
}
