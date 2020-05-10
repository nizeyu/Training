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
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
  }

  private int findHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
  }
}
