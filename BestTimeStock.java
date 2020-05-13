public class BestTimeStock{
	public int maxProfitBruteForce(int[] prices){
		if (prices==null || prices.length == 0) return 0;
        int max=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
	}

	public int maxProfit(int[] prices){
		if (prices==null || prices.length == 0) return 0;
        int maxToCurr = 0;
        int minSoFar = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i] < minSoFar){// 当前买入价更低
                minSoFar = prices[i];
            } else {// 当前卖出价高于买入价
                maxToCurr = Math.max(maxToCurr, prices[i]-minSoFar);
            }
        }
        return maxToCurr;
	}
}
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/