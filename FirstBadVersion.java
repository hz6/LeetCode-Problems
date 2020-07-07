/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion {
  private boolean isBadVersion(int n) {
    return n % 2 == 0 ? true : false;
  }

  public int firstBadVersion(int n) {
    int lo = 1;
    int hi = n;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBadVersion(mid)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
}

// https://leetcode.com/problems/first-bad-version/