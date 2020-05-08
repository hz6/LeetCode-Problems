public class JudgeSquareSum {
	public boolean solution(int c){
		
		int lower = 0;
        int upper = (int) Math.floor(Math.sqrt(c));
        
        while (lower <= upper) {

            int lowerSqr = lower * lower;
            int upperSqr = upper * upper;
            
            if (lowerSqr + upperSqr > c) {
            
                upper --;
            
            } else if (lowerSqr + upperSqr < c) {
            
                lower ++;
            
            } else {
            
                return true;
            
            }
        }
        return false;
	}
}

//https://leetcode.com/problems/sum-of-square-numbers/description/