import java.util.*;

public class FrequencySort {
    private Map<Character, Integer> charFreq;

    public String solution(String s) {
        charFreq = new HashMap<>();
        // character(key):frequency(value)
        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }
        // buckets: array of ArrayLists
        // index is the frequency
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char charKey : charFreq.keySet()) {
            int freq = charFreq.get(charKey);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(charKey);
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char ch : buckets[i]) {
                int freqOfChar = i;
                for (int j = 0; j < freqOfChar; j++) {
                    strBuilder.append(ch);
                }
            }
        }
        return strBuilder.toString();
    }
}
// https://leetcode.com/problems/sort-characters-by-frequency/