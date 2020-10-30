public class SingleNumberII {
	public singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            int count = map.containsKey(x) ? map.get(x) : 0;
            map.put(x, count + 1);
        }
        
        for (int x : map.keySet()) {
            if (map.get(x) == 1) return x;
        }
        
        throw new IllegalArgumentException("no single number");
	}
	public int singleNumber2(int[] nums) {
		if (nums.length == 1) return nums[0];
        int res = 0, mask = 1;
        for (int i = 0; i < 32; i ++) {
            int sum = 0;
            for (int n : nums) {
                sum += (n >> i) & mask;
                sum %= 3;
            }
            
            res = res | (sum << i);
        }
        return res;
	}
}