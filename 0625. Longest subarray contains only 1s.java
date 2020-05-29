public class Solution {
  public int longestConsecutiveOnes(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int count = 0;
    int longest = 0;
    int slow = 0;
    int fast = 0;
    while (fast < nums.length) {
      if (nums[fast] == 1) {
        longest = Math.max(longest, ++fast - slow);
      } else if (count < k) {
        count++;
        longest = Math.max(longest, ++fast - slow);
      } else if (nums[slow++] == 0) {
        count--;
      }
    }
    return longest;
  }
}
