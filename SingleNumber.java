public class SingleNumber {
	public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for (int x: nums) {
            if (map.get(x) == 1) {
                return x;
            }
        }
        throw new IllegalArgumentException("No single element");
	}
	
	// Bit Manipulation
	// x = x ^ 0
	public int singleNumber2(int[] nums) {
		int num = 0;
        for (int x : nums) {
            num = num ^ x;
        }
        return num;
	}
}