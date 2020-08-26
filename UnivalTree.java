public class UnivalTree{
	public boolean isUnivalTree1(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null && root.right != null) {
            return root.val == root.right.val && isUnivalTree(root.right);
        }
        if (root.right == null && root.left != null) {
            return root.val == root.left.val && isUnivalTree(root.left);
        }
        if (root.val != root.left.val || root.val != root.right.val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
	}

	public boolean isUnivalTree2(TreeNode root) {
		boolean leftUnival = (root.left == null) || root.val == root.left.val && isUnivalTree(root.left);
        boolean rightUnival = (root.right == null) || root.val == root.right.val && isUnivalTree(root.right);
        return leftUnival && rightUnival;
	}
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */