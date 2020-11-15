public class UniquePath {
	public int uniquePaths(int m, int n) {
		int[][] gridCell = new int[m][n];

		gridCell[0][0] = 1;
		for (int i = 0; i < m; i ++) gridCell[i][0] = 1;
		for (int j = 0; j < n; j ++) gridCell[0][j] = 1;

		for (int x = 1; x < m; x ++) {
			for (int y = 1; y < n; y ++) {
				gridCell[x][y] = gridCell[x - 1][y] + gridCell[x][y - 1];
			}
		}
		return gridCell[m - 1][n - 1];
	}
}

//https://leetcode.com/problems/unique-paths/