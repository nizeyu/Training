public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> result = new ArrayList<>();
    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return result;
    }

    int i = 0; 
    int j = 0;
    while (i < A.length && j < B.length) {
      if (A[i] == B[j]) {
        result.add(A[i]);
        i++;
        j++;
      } else if (A[i] < B[j]) {
        i++;
      } else {
        j++;
      }
    }

    return result;
  }
}

public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> result = new ArrayList<>();
    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return result;
    }

    HashMap<Integer, Integer> countA = new HashMap<>();
    for (int num : A) {
      countA.put(num, countA.getOrDefault(num, 0) + 1);
    }

    HashMap<Integer, Integer> countB = new HashMap<>();
    for (int num : B) {
      countB.put(num, countB.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
      Integer ctInB = countB.get(entry.getKey());
      if (ctInB != null) {
        int appear = Math.min(entry.getValue(), ctInB);
        for (int i = 0; i < appear; i++) {
          result.add(entry.getKey());
        }
      }
    }

    return result;
  }
}
