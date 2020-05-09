public class MergeSortedArray {
	public void solution(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1, //last index of nums1 
            j = n-1, //last index of nums2
            k = m+n-1; //last index of final result
        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        
        while (j>=0) {
            nums1[k--] = nums2[j--];
        }
	}
}
// https://leetcode.com/problems/merge-sorted-array/