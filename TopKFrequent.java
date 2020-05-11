public class TopKFrequent{
	private HashMap<Integer,Integer> map;
	public int[] solution(int[] nums, int k){
		// Key: number, Value: frequency of this number
        map = new HashMap<>();
        for (int i: nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // index: frequency, Element: number with this frequency
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for (int idx: map.keySet()) {
            int freq = map.get(idx);
            if (buckets[freq]==null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(idx);
        }
        List<Integer> topK = new ArrayList<>();
        int m = buckets.length-1;
        while(m>=0 && topK.size()<k){
            if(buckets[m]==null){// this frequenct does not exist
                m--;
                continue;
            }
             // frequency i is used as index, the higher frequency(i) it is, the more it is near to the tail of Array buckets
            if(buckets[m].size() <= k - topK.size()){
                topK.addAll(buckets[m]);
            }else{
                topK.addAll(buckets[m].subList(0,k-topK.size()));
            }
            m--;
        }
        int[] res=new int[topK.size()];
        for(int j=0;j<res.length;j++){
            res[j]=topK.get(j);
        }
        return res;
	}
}