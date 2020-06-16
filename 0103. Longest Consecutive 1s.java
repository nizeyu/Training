public class Solution {
  public int longest(int[] array) {
    int max = 0;
    int cur = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 1) {
        if (i == 0 || array[i - 1] == 0) {
          cur = 1;
        } else {
          cur++;
        }
        max = Math.max(max, cur);
      }
    }

    return max;
  }
}

public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) {
      return 0;
    }
    
    int max = array[0];
    int[] dp = new int[array.length];
    dp[0] = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] == 1) {
        dp[i] = dp[i - 1] + 1; 
      } else {
        dp[i] = 0;
      }

      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
