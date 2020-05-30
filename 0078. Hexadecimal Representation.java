public class Solution {
  public String hex(int number) {
    if (number <= 0) {
      return "0x0";
    }

    char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    StringBuilder sb = new StringBuilder();
    while (number > 0) {
      int remainder = number % 16;
      number /= 16;
      sb.append(base[remainder]);
    }
    sb.append("x0");
    sb.reverse();
    return sb.toString();
  }
}

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
