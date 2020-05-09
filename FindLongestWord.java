import java.util.List;
public class FindLongestWord{
	private boolean isSubseq(String s, String target){
		int i = 0, j = 0;
        while(i < s.length() && j < target.length()){
            if(s.charAt(i) == target.charAt(j)){
                j++;
            }
            i++;
        }
        return j==target.length();
	}

	public String solution(String s, List<String> d){
		String longestWord="";
        for(String target: d){
            int len1 = longestWord.length();
            int len2 = target.length();
            if (len1 > len2 // your current word is longer than the upcomming word
               || len1 == len2 && longestWord.compareTo(target) < 0) { // longestWord needs to be lexicographically lower than target
                continue;
            }
            if (isSubseq(s,target)){
                longestWord = target;
            }
        }
        return longestWord;
	}
}
//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/