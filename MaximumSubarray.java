public class MaximumSubarray{
/*	
	public int solution(int[] nums){
		if (nums == null || nums.length == 0) return 0;
        
        int maxVal = nums[0];
        int maxToCurr = nums[0];
        int minToCurr = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            int TempMax = maxToCurr + nums[i];
            int TempMin = minToCurr + nums[i];
            
            maxToCurr = Math.max(nums[i], Math.max(TempMax, TempMin));
            minToCurr = Math.min(nums[i], Math.min(TempMax, TempMin));
            
            maxVal = Math.max(maxToCurr, maxVal);
        }
        return maxVal;
	}
*/
	public int kadaneSolution(int[] nums){ // DP is faster
		int maxGlobal=nums[0];
        int maxToCurr=nums[0];
        for(int i=1;i<nums.length;i++){
            maxToCurr = Math.max(nums[i],maxToCurr+nums[i]);
            if (maxToCurr>maxGlobal){
                maxGlobal=maxToCurr;
            }
        }
        return maxGlobal;
	}
}
// Time:O(n)
// Space:O(1)
// https://leetcode.com/problems/maximum-subarray/description/