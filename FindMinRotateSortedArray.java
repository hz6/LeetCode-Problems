public class FindMinRotateSortedArray {
  public int findMin(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (mid > 0 && nums[mid] < nums[mid - 1]) {
        return nums[mid];
      } else if (nums[lo] <= nums[mid] && nums[hi] < nums[mid]) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return nums[lo];
  }
}
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/