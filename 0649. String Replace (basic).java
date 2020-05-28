public class Solution {
  public String replace(String input, String source, String target) {
    char[] array = input.toCharArray();
    if (source.length() >= target.length()) {
      return replaceShorter(array, source, target);
    }
    return replaceLonger(array, source, target);
  }

  public String replaceShorter(char[] input, String source, String target) {
    int slow = 0;
    int fast = 0;
    while (fast < input.length) {
      if (fast <= input.length - source.length() && equalSubstring(input, fast, source)) {
        copySubstring(input, slow, target);
        slow += target.length();
        fast += source.length();
      } else {
        input[slow++] = input[fast++];
      }
    }

    return new String(input, 0, slow);
  }

  public String replaceLonger(char[] input, String source, String target) {
    List<Integer> matches = getAllMatches(input, source);
    char[] result = new char[input.length + matches.size() * (target.length() - source.length())];
    int lastIndex = matches.size() - 1;
    int fast = input.length - 1;
    int slow = result.length - 1;
    while (fast >= 0) {
      if (lastIndex >= 0 && fast == matches.get(lastIndex)) {
        copySubstring(result, slow - target.length() + 1, target);
        slow -= target.length();
        fast -= source.length();
        lastIndex--;
      } else {
        result[slow--] = input[fast--];
      }
    }

    return new String(result);
  }

  // check if the substring from fromIndex is the same as s.
  private boolean equalSubstring(char[] input, int fromIndex, String target) {
    for (int i = 0; i < target.length(); i++) {
      if (input[fromIndex + i] != target.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  // copy the string target to result at fromIndex
  private void copySubstring(char[] input, int fromIndex, String target) {
    for (int i = 0; i < target.length(); i++) {
      input[fromIndex + i] = target.charAt(i);
    }
  }

  // get all the matches of s end position in input
  private List<Integer> getAllMatches(char[] input, String source) {
    List<Integer> matches = new ArrayList<>();
    for (int i = 0; i <= input.length - source.length(); i++) {
      if (equalSubstring(input, i, source)) {
        matches.add(i + source.length() - 1);
      }
    }

    return matches;
  }
}
