public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxCurr = nums[0];
		int maxGlobal = maxCurr;

		for (int i = 1; i < nums.length; i++) {
			maxCurr = Math.max(nums[i], maxCurr + nums[i]);
			maxGlobal = Math.max(maxGlobal, maxCurr);
		}

		return maxGlobal;
	}
}
// https://leetcode.com/problems/maximum-subarray/