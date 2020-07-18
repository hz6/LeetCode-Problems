import java.util.List;
import java.util.ArrayList;

public class Permutation {
  List<List<Integer>> res;
  boolean[] seen;

  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();
    if (nums == null || nums.length == 0)
      return res;
    seen = new boolean[nums.length];
    permuteHelper(new ArrayList<Integer>(), nums);
    return res;
  }

  private void permuteHelper(List<Integer> subset, int[] nums) {
    if (subset.size() == nums.length) {
      res.add(new ArrayList<Integer>(subset));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!seen[i]) {
        subset.add(nums[i]);
        seen[i] = true;
        permuteHelper(subset, nums);
        subset.remove(subset.size() - 1);
        seen[i] = false;
      }
    }
  }
}