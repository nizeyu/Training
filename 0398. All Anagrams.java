public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    List<Integer> result = new ArrayList<>();
    if (lo.length() == 0) {
      return result;
    }

    if (sh.length() > lo.length()) {
      return result;
    }

    Map<Character, Integer> map = countMap(sh);
    int match = 0;
    for (int i = 0; i < lo.length(); i++) {
      char tmp = lo.charAt(i);
      Integer count = map.get(tmp);
      if (count != null) {
        map.put(tmp, count - 1);
        if (count == 1) {
          match++;
        }
      }
      if (i >= sh.length()) {
        tmp = lo.charAt(i - sh.length());
        count = map.get(tmp);
        if (count != null) {
          map.put(tmp, count + 1);
          if (count == 0) {
            match--;
          }
        }
      }

      if (match == map.size()) {
        result.add(i - sh.length() + 1);
      }
    }
    
    return result;
  }

  private Map<Character, Integer> countMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    return map;
  }
}
