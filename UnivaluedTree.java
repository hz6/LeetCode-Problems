public UnivaluedTree {
	public boolean isUnivalTree(TreeNode root) {
        
        boolean leftCorr = root.left == null || 
            root.val == root.left.val && isUnivalTree(root.left);
        
        boolean rightCorr = root.right == null || 
            root.val == root.right.val && isUnivalTree(root.right);
        
        return leftCorr && rightCorr;
    }
}