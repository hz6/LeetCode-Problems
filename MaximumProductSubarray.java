public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) return 0;

		int maxVal = nums[0];
		int maxToCurr = nums[0];
		int minToCurr = nums[0];

		for (int i = 1; i < nums.length; i ++) {

			int nextMax = maxToCurr * nums[i];
			int nextMin = minToCurr * nums[i];

			maxToCurr = Math.max(nums[i], Math.max(nextMax, nextMin));
			minToCurr = Math.min(nums[i], Math.min(nextMax, nextMin));

			maxVal=Math.max(maxVal, maxToCurr);

		}

		return maxVal;
	}
}
// https://leetcode.com/problems/maximum-product-subarray/