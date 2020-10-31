public class BTZigzagTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		boolean left2right = true;
		while (queue.size() != 0) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();

			for (int i=0; i<size; i++) {
			    TreeNode curr = queue.poll();
			    
			    if (left2right) {
			        level.add(curr.val);
			    } else {
			        level.add(0, curr.val);
			    }
			    
			    if (curr.left != null) queue.offer(curr.left);
			    if (curr.right != null) queue.offer(curr.right);
			}
			res.add(level);
			left2right = !left2right;
		}
		return res;
	} 
}