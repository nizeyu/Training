public class Solution {
  public int diffBits(int a, int b) {
    return countBit(a ^ b);
  }

  private int countBit(int number) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += (number >> i) & 1;
    }

    return count;
  }
}
