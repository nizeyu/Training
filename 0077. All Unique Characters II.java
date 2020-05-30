public class Solution {
  public boolean allUnique(String word) {
    int[] set = new int[8];
    for (int i = 0; i < word.length(); i++) {
      char cur = word.charAt(i);
      int row = cur / 32;
      int col = cur % 32;

      if (((set[row] >> col) & 1) == 1) {
        return false;
      }

      set[row] |= (1 << col);
    }

    return true;
  }
}
