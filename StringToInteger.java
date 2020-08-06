public class StringToInteger {

  private static int maxDivBy10 = Integer.MAX_VALUE / 10;

  public int myAtoi(String str) {
    int i = 0;
    int n = str.length();
    while (i < n && Character.isWhitespace(str.charAt(i)))
      i++;
    boolean positive = true; // default positive
    if (i < n && str.charAt(i) == '-') {
      positive = false;
      i++;
    } else if (i < n && str.charAt(i) == '+') {
      i++;
    }
    int number = 0;
    while (i < n && Character.isDigit(str.charAt(i))) {
      int curr = Character.getNumericValue(str.charAt(i));
      // OverFlow situation:
      // number > maxDivBy10 ===> overflows after multiply by 10
      // number == maxDivBy10 && curr >= 8 ===> overflows after add curr
      if (number > maxDivBy10 || (number == maxDivBy10 && curr >= 8)) {
        return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      number = number * 10 + curr;
      i++;
    }

    return positive ? number : -1 * number;
  }
}