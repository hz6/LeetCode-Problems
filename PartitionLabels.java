public class PartitionLabels{
	private int charToIndex(char c){
        return c - 'a';
    }
	public List<Integer> solution(String S){
		int[] lastIndex = new int[26];
        for(int i = 0; i < S.length(); i++){
            lastIndex[charToIndex(S.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int first = 0;
        while(first<S.length()){
            int last = first;
            for(int i = 0;i<S.length()&&i<=last;i++){
                int index = lastIndex[charToIndex(S.charAt(i))];
                if (index>last){
                    last=index;
                }
            }
            partitions.add(last-first+1);
            first = last + 1;
        }
        return partitions;
	}
}
//https://leetcode.com/problems/partition-labels/description/