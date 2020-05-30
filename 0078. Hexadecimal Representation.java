public class Solution {
  public String hex(int number) {
    if (number <= 0) {
      return "0x0";
    }

    char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    boolean isLeading = true;
    StringBuilder sb = new StringBuilder("0x");
    for (int mask_end = 28; mask_end >= 0; mask_end -= 4) {
      char digit = base[(number >> mask_end) & 0xF];
      if (digit != '0' || !isLeading) {
        sb.append(digit);
        isLeading = false;
      }
    }
    return sb.toString();
  }
}
