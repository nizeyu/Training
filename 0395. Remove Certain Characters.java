public class Solution {
  public String remove(String input, String t) {
    if (input == null || input.length() == 0) {
      return input;
    }
    
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);

    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      char cur = array[fast];
      if (!set.contains(array[fast])) {
        array[slow++] = array[fast];
      }
    }

    return new String(array, 0, slow);
  }

  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}
