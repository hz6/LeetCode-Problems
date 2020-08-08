import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    long l = (long) lower;
    long u = (long) upper;
    int n = nums.length;
    List<String> res = new ArrayList<>();
    if (n == 0) {
      addRange(res, l - 1, u + 1);
      return res;
    }
    addRange(res, l - 1, nums[0]);
    for (int i = 1; i < n; i++) {
      addRange(res, nums[i - 1], nums[i]);
    }
    addRange(res, nums[n - 1], u + 1);
    return res;
  }

  private void addRange(List<String> res, long lo, long hi) {
    if (lo == hi) {
      return;
    } else if (hi - lo == 1) {
      return;
    } else if (lo + 1 == hi - 1) {
      res.add(String.valueOf(lo + 1));
    } else {
      String range = (lo + 1) + "->" + (hi - 1);
      res.add(range);
    }
  }
}