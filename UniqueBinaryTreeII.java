import java.util.ArrayList;
import java.util.List;

public class UniqueBinaryTreeII {
  public List<TreeNode> generateTrees(int n) {
    if (n < 1) {
      return new ArrayList<TreeNode>();
    }
    return createSubtrees(1, n);
  }

  private List<TreeNode> createSubtrees(int start, int end) { // 创建子树
    List<TreeNode> res = new ArrayList<>();

    if (start > end) { // break condition: 当只有一个节点时
      res.add(null);
      return res;
    }

    for (int i = start; i <= end; i++) { // 把每一个数都作为子节点，分别计算
      List<TreeNode> leftSubs = createSubtrees(start, i - 1);
      List<TreeNode> rightSubs = createSubtrees(i + 1, end);
      for (TreeNode l : leftSubs) {
        for (TreeNode r : rightSubs) {
          TreeNode root = new TreeNode(i, l, r);
          res.add(root);
        }
      }
    }

    return res;
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