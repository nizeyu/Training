public class Solution {
  public int largest(int[][] matrix) {
    int N = matrix.length;
    if (N == 0) {
      return 0;
    }

    int result = 0;
    // dp[i][j] means the largest square of 1's with right bottom
    // corner as matrix[i][j]
    int[][] dp = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
        } else {
          if (matrix[i][j] == 0) {
            dp[i][j] = 0;
          } else {
            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          }
        }
        result = Math.max(result, dp[i][j]);
      }
    }

    return result;
  }
}
