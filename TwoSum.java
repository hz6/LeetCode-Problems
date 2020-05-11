import java.util.*;

public class TwoSum{ // java solution

	public static int[] BruteForce(int[] nums, int target){ // O(n^2)

		int length = nums.length;
		
		for (int i=0; i<length-1; i++) 
		{
			for (int j=i+1; j<length; j++) 
				if (nums[i]+nums[j] == target) 
					return new int[]{i,j};

		}
		return new int[]{-1};
	}

	public static int[] solution(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) { //map { nums[i]()key : i(value)}
			map.put(nums[i],i);
		}
		for (int i = 0; i < nums.length; i++) { // Check the complement of every element in nums
			int complement = target-nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		return new int[]{-1};// not found
	}

}