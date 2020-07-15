public class NumsOfIsland {
  public int islandCount(char[][] grid) {
    if (grid.length == 0)
      return 0;
    int row = grid.length;
    int col = grid[0].length;
    int numIsland = 0;
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (grid[r][c] == '1') {
          searchIsland(grid, r, c);
          numIsland++;
        }
      }
    }
    return numIsland;
  }

  public void searchIsland(char[][] grid, int row, int col) {
    if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid[0].length) || (grid[row][col] == '0')) {
      return;
    }

    grid[row][col] = '0';

    searchIsland(grid, row + 1, col);
    searchIsland(grid, row - 1, col);
    searchIsland(grid, row, col + 1);
    searchIsland(grid, row, col - 1);
  }
}