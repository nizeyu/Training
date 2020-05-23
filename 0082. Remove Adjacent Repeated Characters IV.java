public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() <= 1) {
      return input;
    }

    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 1; fast < array.length; fast++) {
      if (slow == -1 || array[fast] != array[slow]) {
        array[++slow] = array[fast];
      } else {
        slow--;
        while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
          fast++;
        }
      }
    }
    return new String(array, 0, slow + 1);
  }
}

public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() <= 1) {
      return input;
    }

    char[] array = input.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    int fast = 0;
    while (fast < array.length) {
      char curChar = array[fast];
      if (!stack.isEmpty() && stack.peekFirst() == curChar) {
        while (fast < array.length && array[fast] == curChar) {
          fast++;
        }
        stack.pollFirst();
      } else {
        stack.offerFirst(curChar);
        fast++;
      }
    }

    int len = stack.size();
    for (int i = len - 1; i >= 0; i--) {
      array[i] = stack.pollFirst();
    }

    return new String(array, 0, len);
  }
}
