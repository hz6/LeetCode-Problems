public class LongestSubstringTwoDistinct {
  public int solution(String s) {
    int[] charMap = new int[128];
    int i = 0, maxLen = 0, distinct = 0;
    for (int j = 0; j < s.length(); j++) {
      if (charMap[s.charAt(j)] == 0)
        distinct++;
      charMap[s.charAt(j)]++;
      while (distinct > 2) {
        charMap[s.charAt(i)]--;
        if (charMap[s.charAt(i)] == 0)
          distinct--;
        i++;
      }
      maxLen = Math.max(j - i + 1, maxLen);
    }
    return maxLen;
  }
}