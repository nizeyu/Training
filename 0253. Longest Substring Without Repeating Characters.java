public class Solution {
  public int longest(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    int longest = 0;
    int slow = 0;
    int fast = 0;
    while (fast < input.length()) {
      if (map.containsKey(input.charAt(fast))) {
        map.remove(input.charAt(slow++));
      } else {
        map.put(input.charAt(fast++), 1);
        longest = Math.max(longest, fast - slow);
      }
    }
    
    return longest;
  }
}
