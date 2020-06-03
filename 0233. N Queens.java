public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> result = new ArrayList<>();

    dfs(n, new ArrayList<>(), result);

    return result;
  }

  private void dfs(int n, List<Integer> sol, List<List<Integer>> result) {
    if (sol.size() == n) {
      result.add(new ArrayList<>(sol));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (!valid(sol, i)) {
        continue;
      }

      sol.add(i);
      dfs(n, sol, result);
      sol.remove(sol.size() - 1);
    }
  }

  private boolean valid(List<Integer> sol, int col) {
    int row = sol.size();
    for (int i = 0; i < row; i++) {
      if (sol.get(i) == col || Math.abs(sol.get(i) - col) == row - i) {
        return false;
      }
    }
    return true;
  }
}
