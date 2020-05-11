import java.util.PriorityQueue;
import java.util.Arrays;
public class FindKthLargest{
	public int solutionI(int[] nums, int k){
		Arrays.sort(nums);
        int tail = nums.length - 1;
        return nums[tail-(k-1)];
	}
	// In Java, The head of this queue is the least element
	public int solutionII(int[] nums, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i: nums){
			pq.add(i);
		}
		// In Java, The head of this queue is the least element
		while(pq.size()>k){ // k-n,k-n+1,k-n+2...k
			pq.poll();
		}
		return pq.peek();
	} 
}