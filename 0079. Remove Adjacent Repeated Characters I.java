public class Solution {
  public String deDup(String input) {
    if (input == null) {
      return input;
    }
    
    char[] array = input.toCharArray();

    int slow = 0;
    for (int fast = 0; fast < array.length; fast++) {
      if (fast == 0 || (fast != 0 && array[fast] != array[slow - 1])) {
        array[slow++] = array[fast];
      }
    }

    return new String(array, 0, slow);
  }
}
