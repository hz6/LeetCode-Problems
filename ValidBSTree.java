public class ValidBSTree {
	private TreeNode prev;
	public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSubtreeLess(root.left, root.val) && isSubtreeGreater(root.right, root.val) &&
            isValidBST(root.left) && isValidBST(root.right);
        
    }

    private boolean isSubtreeLess(TreeNode root, int val) {
        if (root == null) return true;
        return root.val < val &&
            isSubtreeLess(root.left, val) &&
            isSubtreeLess(root.right, val);
    }

    private boolean isSubtreeGreater(TreeNode root, int val) {
        if (root == null) return true;
        return root.val > val &&
            isSubtreeGreater(root.left, val) &&
            isSubtreeGreater(root.right, val);
    }

    public boolean isValidBST2(TreeNode root) {
		// (root, -infinity, +infinity)
		return isSubtreeInRange(root, null, null);
    }

	private boolean isSubtreeInRange(TreeNode p, Integer min, Integer max) {
		if (p == null) return true;
		return (min == null || p.val > min) && (max == null || p.val < max) 
			&& isSubtreeInRange(p.left, min, p.val)
			&& isSubtreeInRange(p.right, p.val, max);
    }

    public boolean isValidBST3(TreeNode root) {
        prev = null;
        return isInOrder(root);
    }
    public boolean isInOrder(TreeNode p) {
        if (p == null) return true;
        boolean leftValid = isInOrder(p.left);
        if (prev != null && p.val <= prev.val) return false;
        prev = p;
        boolean rightValid = isInOrder(p.right);
        return leftValid && rightValid;
    }
    public boolean isValidBST4(TreeNode root) {
        prev = null;
        return isInOrderCutLeaf(root);
    }
    public boolean isInOrderCutLeaf(TreeNode p) {
        if (p == null) return true;
        if (isInOrderCutLeaf(p.left)) {
            if (prev != null && prev.val >= p.val) return false;
            prev = p;
            return isInOrderCutLeaf(p.right);
        }
        return false;
    }
}