public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		return createSubtree(nums,0,nums.length-1);
	}
	public TreeNode createSubtree(int[] nums, int low, int high) {
        if (low > high) return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createSubtree(nums, low, mid - 1);
        node.right = createSubtree(nums, mid + 1, high);
        return node;
    }
}