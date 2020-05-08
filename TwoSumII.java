public class TwoSumII extends {
	public int[] solution(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0) {
            return null;
        }
        
        int lower = 0;
        int upper = numbers.length - 1;
        
        while (lower < upper) {
            if (numbers[lower] + numbers[upper] > target) {
                upper--;
            } else if (numbers[lower] + numbers[upper] < target) {
                lower++;
            } else {
                return new int[] {lower + 1, upper + 1};
            }
        }
        
        return new int[] {-1};
	}
}