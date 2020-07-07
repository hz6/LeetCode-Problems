public class SquareRoot {
  public int solution(int x) {
    if (x == 1 || x == 0) {
      return x;
    }
    int l = 1, h = x;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      int sqrt = x / mid;
      if (mid == sqrt) {
        return mid;
      } else if (mid > sqrt) {
        h = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return h;
  }
}
// https://leetcode.com/problems/sqrtx/description/