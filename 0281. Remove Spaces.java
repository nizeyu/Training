public class Solution {
  public String removeSpaces(String input) {
    if (input.isEmpty()) {
      return input;
    }
    
    char[] array = input.toCharArray();
    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (array[fast] != ' ') {
        array[slow++] = array[fast];
      } else {
        if (slow == 0 || array[slow - 1] == ' ') {
          continue;
        }
        
        array[slow++] = array[fast];
      }
    }

    if (slow > 0 && array[slow - 1] == ' ') {
      slow--;
    }

    return new String(array, 0, slow);
  }
}
