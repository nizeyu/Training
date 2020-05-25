public class Solution {
  public String reverse(String input) {
    if (input == null || input.length() <= 1) {
      return input;
    }

    char[] chars = input.toCharArray();

    reverseHelper(chars, 0, chars.length - 1);

    return new String(chars);
  }

  private void reverseHelper(char[] chars, int left, int right) {
    if (left >= right) {
      return;
    }

    char temp = chars[left];
    chars[left] = chars[right];
    chars[right] = temp;

    reverseHelper(chars, left + 1, right - 1);
  }
}

public class Solution {
  public String reverse(String input) {
    if (input == null || input.length() <= 1) {
      return input;
    }

    char[] chars = input.toCharArray();
    int i = 0;
    int j = chars.length - 1;
    while (i < j) {
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
      i++;
      j--;
    }

    return new String(chars);
  }
}
