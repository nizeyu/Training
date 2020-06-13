public class Solution {
  public int minJump(int[] array) {
    int n = array.length;
    if (n == 1) {
      return 0;
    }

    int[] dp = new int[n];
    dp[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      dp[i] = -1;
      if (i + array[i] > n - 1) {
        dp[i] = 1;
      } else {
        int min = Integer.MAX_VALUE;
        for (int j = array[i]; j >= 1; j--) {
          if (dp[i + j] != -1) {
            min = Math.min(min, dp[i + j]);
          } 
        }
        if (min != Integer.MAX_VALUE) {
          dp[i] = min + 1;
        }
      } 
    }

    return dp[0];
  }
}

public class Solution {
  public int minJump(int[] array) {
    int n = array.length;
    if (n == 1) {
      return 0;
    }

    int[] dp = new int[n];
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
      dp[i] = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (j + array[j] >= i && dp[j] != -1) {
          if (dp[i] == -1 || dp[i] > dp[j] + 1) {
            dp[i] = dp[j] + 1;
          }
        }
      }
    }

    return dp[n - 1];
  }
}
