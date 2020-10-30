public class BTMaxPathSum {
	private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findmaxHelper(root);
        return max;
    }
    public int findmaxHelper(TreeNode node) {
        if (node == null) return 0;
        int left = findmaxHelper(node.left); // max path root left cannot have branches
        int right = findmaxHelper(node.right); // max path root right cannot have branches
        int ret = node.val + Math.max(left, right);
        max = Math.max(max, node.val + left + right);
        return ret > 0 ? ret : 0;
    }
}