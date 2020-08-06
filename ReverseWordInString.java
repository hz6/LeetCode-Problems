public class ReverseWordInString {
  public String reverseWords(String s) {
    String[] strArr = s.trim().split(" ");
    StringBuffer reversed = new StringBuffer();
    for (int i = strArr.length - 1; i >= 0; i--) {
      if (strArr[i].trim().length() != 0) {
        reversed.append(strArr[i] + " ");
      }
    }

    return reversed.toString().trim();
  }
}