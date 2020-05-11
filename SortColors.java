public class SortColors{
	private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
	public void solution(int nums[]){
		int zero = -1;
        int one = 0;
        int two = nums.length;
        while (one < two) {
            if (nums[one] == 0){
                zero++;
                swap(nums,zero,one);
                one++;
            } else if (nums[one] == 2) {
                two--;
                swap(nums,one,two);
            } else {
                one++;
            }
        }
	}
}
//https://leetcode.com/problems/sort-colors/