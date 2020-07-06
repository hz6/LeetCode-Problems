import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> solution(String S) {
        if (S.length() == 0)
            return null;

        List<Integer> partition = new ArrayList<>();

        int[] lastIndices = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndices[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndices[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }

        return partition;
    }
}
// https://leetcode.com/problems/partition-labels/description/