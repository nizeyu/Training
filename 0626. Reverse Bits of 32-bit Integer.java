public class Solution {
  public long reverseBits(long n) {
    int i = 0;
    int j = 31;
    while (i < j) {
      n = swap(n, i, j);
      i++;
      j--;
    }

    return n;
  }

  private long swap(long n, int i, int j) {
    long bi = (n >> i) & 1L;
    long bj = (n >> j) & 1L;

    if (bi == bj) {
      return n;
    }

    return n ^ ((1L << i) + (1L << j));
  }
}
