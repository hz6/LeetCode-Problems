public class GetLonelyNode {
	
	List<Integer> res = new ArrayList<>();
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right != null) {
            res.add(node.right.val);
            helper(node.right);
        }
        else if (node.left != null && node.right == null) {
            res.add(node.left.val);
            helper(node.left);
        } else {
            helper(node.left);
            helper(node.right);
        }
        
    }
}