public class BestTimeStockII{
	public int solution(int[] prices){
		int profit = 0;
        for(int i=1;i<prices.length;i++){
            if (prices[i] > prices[i-1]) {
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;
	}
}
//如果有 a <= b <= c <= d ，那么最大收益为 d - a。而 d - a = (d - c) + (c - b) + (b - a)
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/