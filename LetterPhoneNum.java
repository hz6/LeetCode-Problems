import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterPhoneNum {
  private HashMap<Character, char[]> map;
  private List<String> res;

  public List<String> letterCombinations(String digits) {
    res = new ArrayList<>();
    if (digits == null || digits.length() == 0)
      return res;
    map = new HashMap<>();
    map.put('2', new char[] { 'a', 'b', 'c' });
    map.put('3', new char[] { 'd', 'e', 'f' });
    map.put('4', new char[] { 'g', 'h', 'i' });
    map.put('5', new char[] { 'j', 'k', 'l' });
    map.put('6', new char[] { 'm', 'n', 'o' });
    map.put('7', new char[] { 'p', 'q', 'r', 's' });
    map.put('8', new char[] { 't', 'u', 'v' });
    map.put('9', new char[] { 'w', 'x', 'y', 'z' });

    helper("", 0, digits);
    return res;
  }

  public void helper(String curr, int currIdx, String digits) {
    if (currIdx == digits.length()) {
      res.add(curr);
    }
    char c = digits.charAt(currIdx);
    for (char ch : map.get(c)) {
      helper(curr + ch, currIdx + 1, digits);
    }
  }
}
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/