public class NonDecreasingArray{
	public boolean checkPossibility(int[] nums){
		if(nums.length==0) return false;
        int count=0;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                count++;
                if(count>1)
                    return false;
                
                if(i-2<0||nums[i-2]<=nums[i]){
                    nums[i-1]=nums[i];
                }else{
                    nums[i]=nums[i-1];
                }
            }
        }
        return true;
	}
}
/*
1) 2 4 2 6 -> 2 2 2 6

2) 3 4 2 6 -> 3 4 4 6
*/
//https://leetcode.com/problems/non-decreasing-array/description/