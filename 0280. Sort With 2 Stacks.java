public class Solution {
  public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.size() <= 0) {
      return;
    }
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    
    sort(s1, s2);
  }

  private void sort(Deque<Integer> input, Deque<Integer> buffer) {
    // input: unsorted elements
    // buffer: (top part) buffer, (bottom part) sorted elements
    // Step 1: sort in ascending order and store result in buffer
    while (!input.isEmpty()) {
      int min = Integer.MAX_VALUE;
      int count = 0;
      while (!input.isEmpty()) {
        int cur = input.pollFirst();
        if (cur < min) {
          min = cur;
          count = 1;
        } else if (cur == min) {
          count++;
        }

        buffer.offerFirst(cur);
      }

      while (!buffer.isEmpty() && buffer.peekFirst() >= min) {
        int tmp = buffer.pollFirst();
        if (tmp != min) {
          input.offerFirst(tmp);
        }
      }

      while (count > 0) {
        buffer.offerFirst(min);
        count--;
      }
    }
    // Step 2: move result from buffer to input, so it's in descending order
    while (!buffer.isEmpty()) {
      input.offerFirst(buffer.pollFirst());
    }
  }
}
