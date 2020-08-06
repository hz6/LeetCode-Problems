public class ValidNumber {
  public boolean isValid(String s) {
    int i = 0;
    int n = s.length();
    while (i < n && Character.isWhitespace(s.charAt(i)))
      i++;
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
      i++;
    boolean isNumerical = false;
    while (i < n && Character.isDigit(s.charAt(i))) {
      i++;
      isNumerical = true;
    }
    if (i < n && s.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumerical = true;
      }
    }
    if (i < n && s.charAt(i) == 'e' && isNumerical) {
      i++;
      isNumerical = false;
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-'))
        i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumerical = true;
      }
    }
    while (i < n && Character.isWhitespace(s.charAt(i)))
      i++;
    return i == n && isNumerical;
  }

  public boolean isNumber(String s) {
    s = s.trim();
    boolean eSeen = false;
    boolean dotSeen = false;
    boolean numSeen = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        numSeen = true;
      } else if (c == 'e') {
        if (eSeen || !numSeen)
          return false;
        eSeen = true;
        numSeen = false;
      } else if (c == '.') {
        if (eSeen || dotSeen)
          return false;
        dotSeen = true;
      } else if (c == '-' || c == '+') {
        if (i != 0 && s.charAt(i - 1) != 'e')
          return false;
      } else {
        return false;
      }
    }
    return numSeen;
  }
}