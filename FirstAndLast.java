public class FirstAndLast {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = findStartIndex(nums, target);
    res[1] = findEndIndex(nums, target);
    return res;
  }

  private int findStartIndex(int[] nums, int target) {
    int index = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] >= target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
      if (nums[mid] == target)
        index = mid;
    }

    return index;
  }

  private int findEndIndex(int[] nums, int target) {
    int index = -1;
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] <= target) {

        start = mid + 1;

      } else {

        end = mid - 1;

      }
      if (nums[mid] == target)
        index = mid;
    }

    return index;
  }
}
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/