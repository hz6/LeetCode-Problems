public class ReverseVowel {
	private HashSet<Character> vowelSet;
	public String solution(String s) {
		vowelSet = new HashSet<>(Arrays.asList('a','i','u','e','o','A','I','U','E','O'));
        int i = 0, j = s.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(s);
        
        while (i < j) {
            char v1 = s.charAt(i), v2 = s.charAt(j);
            if (vowelSet.contains(v1) && vowelSet.contains(v2)) {
                stringBuilder.setCharAt(i++, v2);
                stringBuilder.setCharAt(j--, v1);
            } else if (vowelSet.contains(v1) || !vowelSet.contains(v2)) {
                j--;
            } else if (!vowelSet.contains(v1) || vowelSet.contains(v2)) {
                i++;
            }
        }
        return stringBuilder.toString();
	}
}

//https://leetcode.com/problems/reverse-vowels-of-a-string/description/