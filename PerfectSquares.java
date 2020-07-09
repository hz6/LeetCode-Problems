public class PerfectSquares {
  public int numSquares(int n) {
    if (n < 0)
      return 0;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    // we need the least number of perfect square numbers
    for (int i = 1; i <= n; i++) {
      dp[i] = i;// most number of perfect square numbers (all one)
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }
}
// https://leetcode.com/problems/perfect-squares/description/
/*
 * 可以将每个整数看成图中的一个节点，如果两个整数之差为一个平方数，那么这两个整数所在的节点就有一条边。 要求解最小的平方数数量，就是求解从节点 n 到节点
 * 0 的最短路径。
 */