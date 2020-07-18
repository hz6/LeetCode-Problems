import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PacificAtlanticWaterFlow {
  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    if (matrix == null || matrix.length == 0)
      return new ArrayList<>();
    int row = matrix.length;
    int col = matrix[0].length;
    List<List<Integer>> res = new ArrayList<>();
    boolean[][] atlantic = new boolean[row][col];
    boolean[][] pacific = new boolean[row][col];
    for (int i = 0; i < row; i++) {
      dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
      dfs(matrix, atlantic, i, col - 1, Integer.MIN_VALUE);
    }
    for (int j = 0; j < col; j++) {
      dfs(matrix, pacific, 0, j, Integer.MIN_VALUE);
      dfs(matrix, atlantic, row - 1, j, Integer.MIN_VALUE);
    }
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (atlantic[r][c] && pacific[r][c]) {
          List<Integer> coord = new ArrayList<>();
          coord.addAll(Arrays.asList(r, c));
          res.add(coord);
        }
      }
    }
    return res;
  }

  public void dfs(int[][] matrix, boolean[][] canflow, int row, int col, int altitude) {
    if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || canflow[row][col]
        || altitude > matrix[row][col]) {
      return;
    }
    canflow[row][col] = true;
    dfs(matrix, canflow, row + 1, col, matrix[row][col]);
    dfs(matrix, canflow, row - 1, col, matrix[row][col]);
    dfs(matrix, canflow, row, col + 1, matrix[row][col]);
    dfs(matrix, canflow, row, col - 1, matrix[row][col]);
  }
}
// https://leetcode.com/problems/pacific-atlantic-water-flow/