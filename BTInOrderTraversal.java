public class BTInOrderTraversal {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            helper(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            helper(root.right);
        }
    }
}