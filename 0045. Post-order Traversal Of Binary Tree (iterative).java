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
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    TreeNode prev = null;
    while (!stack.isEmpty()) {
      TreeNode cur = stack.peekFirst();
      if (prev == null || cur == prev.left || cur == prev.right) {
        if (cur.left != null) {
          stack.offerFirst(cur.left);
        } else if (cur.right != null) {
          stack.offerFirst(cur.right);
        } else {
          result.add(cur.key);
          stack.pollFirst();
        }
      } else if (prev == cur.left) {
        if (cur.right != null) {
          stack.offerFirst(cur.right);
        } else {
          result.add(cur.key);
          stack.pollFirst();
        }
      } else {
        result.add(cur.key);
        stack.pollFirst();
      }
      prev = cur;
    }

    return result;
  }
}
