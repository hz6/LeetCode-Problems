public class DecideSubsequence{
	public boolean isSubsequence(String s, String t){
		if (s==null || t==null) {
            return false;
        }
        int i=0,j=0;
        while (i<s.length()&&j<t.length()) {
            if (s.charAt(i)==t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i==s.length();
	}
}
//https://leetcode.com/problems/is-subsequence/description/