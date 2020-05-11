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

// Recursion 2: 插在准确的位置
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

    insertHelper(root, key);

    return root;
  }

  private void insertHelper(TreeNode root, int key) {
    if (root.key == key) {
      return;
    } else if (root.key < key) {
      if (root.right == null) {
        root.right = new TreeNode(key);
      } else {
        insert(root.right, key);
      }
    } else {
      if (root.left == null) {
        root.left = new TreeNode(key);
      } else {
        insert(root.left, key);
      }
    }
  }
}

// Iterative 1: look down
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
    TreeNode newNode = new TreeNode(key);
    if (root == null) {
      return newNode;
    }

    TreeNode cur = root;
    while (cur != null) {
      if (cur.key == key) {
        break;
      } else if (cur.key < key) {
        if (cur.right == null) {
          cur.right = new TreeNode(key);
          break;
        } else {
          cur = cur.right;
        }
      } else {
        if (cur.left == null) {
          cur.left = new TreeNode(key);
          break;
        } else {
          cur = cur.left;
        }
      }
    }

    return root;
  }
}

// Iterative 1: look up
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
    TreeNode newNode = new TreeNode(key);
    if (root == null) {
      return newNode;
    }

    TreeNode cur = root;
    TreeNode pre = null;
    while (cur != null) {
      pre = cur;
      if (cur.key == key) {
        return root;
      } else if (cur.key < key) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }

    if (pre.key < key) {
      pre.right = new TreeNode(key);
    } else if (pre.key > key) {
      pre.left = new TreeNode(key);
    }

    return root;
  }
}

