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
      
      int l = 0;
      int r = m * n - 1;
      while(l <= r) {
          int mid = l + (r - l) / 2;
          int num = matrix[mid/n][mid%n]; // map 2D coordinate to 1D coordinate
          
          if (num == target) {
              return new int[]{mid/n, mid%n};
          } else if (num < target) {
              l = mid + 1;;
          } else {
              r = mid - 1;
          }
      }
      
      return new int[]{-1, -1};
  }
}
