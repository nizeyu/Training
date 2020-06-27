/* int global_diff: root
int global_value: root
cur = root;
go through tree cur != null
case 0: cur.val == target, break;

cur_diff < global_diff update

case 1: cur.val < target
cur = cur.right

case 2: cur.val > target
cur = cur.left

return global_value; */

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
  public int closest(TreeNode root, int target) {
    int global_diff = Math.abs(root.key - target);
    int global_val = root.key;
    while (root != null) {
      if (root.key == target) {
        global_val = root.key;
        break;
      }
      
      int cur_diff = Math.abs(root.key - target);
      if (cur_diff < global_diff) {
        global_diff = cur_diff;
        global_val = root.key;
      }
      
      if (root.key < target) {
        root= root.right;
      } else {
        root = root.left;
      }
    }

    return global_val;
  }
}


