public class Solution {
  public boolean existSum(int[] array, int target) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      if (set.contains(target - array[i])) {
        return true;
      }
      set.add(array[i]);
    }

    return false;
  }
}
