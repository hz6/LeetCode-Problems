import java.util.ArrayList;
import java.util.List;

public class DifferentWaysCompute {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> ways = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char operator = input.charAt(i);
      if (operator == '+' || operator == '-' || operator == '*') {
        List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
        List<Integer> rightRes = diffWaysToCompute(input.substring(i + 1));
        for (int l : leftRes) {
          for (int r : rightRes) {
            switch (operator) {
              case '+':
                ways.add(l + r);
                break;
              case '*':
                ways.add(l * r);
                break;
              case '-':
                ways.add(l - r);
            }
          }
        }
      }
    }
    // 如果input是一个无运算符的数字单字符
    // 所以只有一个运算结果，即input本身
    if (ways.size() == 0) {
      ways.add(Integer.valueOf(input));
    }
    return ways;
  }
}
// https://leetcode.com/problems/different-ways-to-add-parentheses/