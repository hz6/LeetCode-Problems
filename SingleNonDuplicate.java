public class SingleNonDuplicate {
  public int solution(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;
    // single element 永远出现在偶数index之下
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (mid % 2 == 0) {
        if (nums[mid] == nums[mid + 1]) {
          lo = mid + 2;
        } else if (nums[mid] == nums[mid - 1]) {
          hi = mid - 2;
        } else {
          return nums[mid];
        }
      } else {
        if (nums[mid] == nums[mid + 1]) {
          hi = mid - 1;
        } else if (nums[mid] == nums[mid - 1]) {
          lo = mid + 1;
        } else {
          return nums[mid];
        }
      }
    }
    return nums[lo];
  }
}
// https://leetcode.com/problems/single-element-in-a-sorted-array/description/