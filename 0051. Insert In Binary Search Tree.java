// Recursion 1: 无差别的挂
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
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }

    if (root.key < key) {
      root.right = insert(root.right, key);
    } 
    
    if (root.key > key) {
      root.left = insert(root.left, key);
    }

    return root;
  }
}
