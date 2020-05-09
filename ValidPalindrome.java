public class ValidPalindrome{
	
	private boolean isPalindrome(String s, int i, int j) {
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

	public boolean solution(String s) {
		int i = 0, j = s.length() - 1;
        while(i < j){
            if (s.charAt(i) != s.charAt(j)) {
                return this.isPalindrome(s, i+1, j) || this.isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
	}
}
