/* TreeNode result = new TreeNode(Integer.MIN_VALUE): 

go through tree root != null

case 1: root.val < target
if root.val > result.val
	result = root;
root = root.right;

case 2: root.val >= target
root = root.left

return result.val; 
*/

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
  public int largestSmaller(TreeNode root, int target) {
    TreeNode result = new TreeNode(Integer.MIN_VALUE);

    while (root != null) {
      if (root.key < target) {
        if (root.key > result.key) {
          result = root;
        }
        root = root.right;
      } else {
        root = root.left;
      }
    }

    return result.key; 
  }
}
