class MyComparator implements Comparator<Map.Entry<String, Integer>> {
  @Override
  public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
    return e1.getValue().compareTo(e2.getValue());
  }
}

public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    if (combo == null || combo.length == 0 || k <= 0) {
      return new String[0];
    }

    HashMap<String, Integer> freqMap = new HashMap<>();
    for (String str : combo) {
      freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
    }

    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new MyComparator());

    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      } else if (entry.getValue() > minHeap.peek().getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }

    String[] result = new String[minHeap.size()];
    for (int i = minHeap.size() - 1; i >= 0; i--) {
      result[i] = minHeap.poll().getKey();
    }

    return result;
  }
}
