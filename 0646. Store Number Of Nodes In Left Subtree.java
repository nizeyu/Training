/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    numNodes(root);
  }

  private int numNodes(TreeNodeLeft root) {
    if (root == null) {
      return 0;
    }
    int leftNum = numNodes(root.left);
    int rightNum = numNodes(root.right);
    root.numNodesLeft = leftNum;
    return leftNum + rightNum + 1;
  }
}
