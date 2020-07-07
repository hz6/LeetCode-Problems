public class SmallestLetterGreaterThanTarget {
  public char solution(char[] letters, char target) {
    int length = letters.length;
    int lo = 0, hi = length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (letters[mid] <= target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return lo < length ? letters[lo] : letters[0];
  }
}

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/