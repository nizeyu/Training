public class Solution {
  public boolean canJump(int[] array) {
    if (array.length == 1) {
      return true;
    }
    
    boolean[] dp = new boolean[array.length];
    dp[dp.length - 1] = true;

    for (int i = dp.length - 2; i >= 0; i--) {
      if (i + array[i] > array.length - 1) {
        dp[i] = true;
      } else {
        for (int j = array[i]; j >= 1; j--) {
          if (dp[i + j]) {
            dp[i] = true;
            break;
          }
        }
      }
    }

    return dp[0];
  }
}
