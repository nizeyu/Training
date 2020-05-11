// Iteration
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
  public TreeNode search(TreeNode root, int key) {
    while (root != null) { // 没必要用cur 指针, 因为是pass-by-value,不会改变原指针的问题。
      if (root.key == key) {
        return root;
      }

      if (root.key < key) {
        root = root.right;
      } else {
        root = root.left;
      }
    }

    return root;
  }
}

// Recursion 
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
  public TreeNode search(TreeNode root, int key) {
    if (root == null || root.key == key) {
      return root;
    }

    if (root.key < key) {
      return search(root.right, key);
    } else {
      return search(root.left, key);
    }
  }
}
