public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int r = obstacleGrid.length;
		int c = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[r - 1][c - 1] == 1) return 0;

		int[][] dp = new int[r][c];
		dp[0][0] = 1;
		for (int i = 1; i < r; i ++) dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i][0] + dp[i - 1][0] : 0;
		for (int j = 1; j < c; j ++) dp[0][j] = obstacleGrid[0][j] == 0 ? dp[0][j] + dp[0][j - 1] : 0;

		for (int x = 1; x < r; x ++) {
			for (int y = 1; y < c; y ++) {
				dp[x][y] = obstacleGrid[x][y] == 0 ? dp[x - 1][y] + dp[x][y - 1]:0;
			}
		}
		return dp[r - 1][c - 1];
	}
}
//https://leetcode.com/problems/unique-paths-ii/