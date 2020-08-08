public class OneEditDistance {
  public boolean isOneEditDistance(String s, String t) {
    int m = s.length(), n = t.length();
    if (m > n)
      return isOneEditDistance(t, s);
    if (n - m > 1)
      return false;
    int i = 0, diff = n - m;
    while (i < m && s.charAt(i) == t.charAt(i))
      i++;
    if (i == m)
      return diff == 1;
    if (diff == 0)
      i++;
    while (i < m && s.charAt(i) == t.charAt(i + diff))
      i++;
    return i == m;
  }
}