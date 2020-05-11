/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    getRangeHelper(root, min, max, res);

    return res;
  }

  private void getRangeHelper(TreeNode root, int min, int max, List<Integer> res) {
    if (root == null) {
      return;
    }

    if (root.key > min) {
      getRangeHelper(root.left, min, max, res);
    }

    if (root.key >= min && root.key <= max) {
      res.add(root.key);
    }

    if (root.key < max) {
      getRangeHelper(root.right, min, max, res);
    }
  }
}
