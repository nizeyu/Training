public class Solution {
  public boolean isPowerOfTwo(int number) {
    if (number <= 0) {
      return false;
    }
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += (number >> i) & 1;
    }

    return (count == 1);
  }
}
