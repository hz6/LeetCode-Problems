import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null)
      return res;
    dfs(root, Integer.toString(root.val), res);
    return res;
  }

  private void dfs(TreeNode node, String value, List<String> res) {
    if (node == null)
      return;
    if (node.left == null && node.right == null) {
      res.add(value);
      return;
    }
    if (node.left != null) {
      dfs(node.left, value + "->" + node.left.val, res);
    }
    if (node.right != null) {
      dfs(node.right, value + "->" + node.right.val, res);
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}