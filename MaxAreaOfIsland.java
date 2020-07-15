public class MaxAreaOfIsland {
  private boolean checked[][];

  public int maxArea(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int maxArea = 0;
    checked = new boolean[row][col];
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {

        maxArea = Math.max(maxArea, area(r, c, grid));
      }
    }
    return maxArea;
  }

  private int area(int row, int col, int[][] grid) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || checked[row][col] == true
        || grid[row][col] == 0) {
      return 0;
    }
    checked[row][col] = true;
    return 1 + area(row + 1, col, grid) + area(row, col + 1, grid) + area(row - 1, col, grid)
        + area(row, col - 1, grid);
  }
}