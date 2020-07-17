public class SurroundingRegions {
  private boolean[][] visited;

  public void solution(char[][] board) {
    if (board == null || board.length == 0)
      return;
    int row = board.length;
    int col = board[0].length;
    visited = new boolean[row][col];
    for (int j = 0; j < col; j++) {
      if (board[0][j] == 'O') {
        dfs(board, 0, j, false);
      }
      if (board[row - 1][j] == 'O') {
        dfs(board, row - 1, j, false);
      }
    }
    for (int i = 0; i < row; i++) {
      if (board[i][0] == 'O') {
        dfs(board, i, 0, false);
      }
      if (board[i][col - 1] == 'O') {
        dfs(board, i, col - 1, false);
      }
    }
    for (int r = 1; r < row - 1; r++) {
      for (int c = 1; c < col - 1; c++) {
        if (board[r][c] == 'O' && !visited[r][c]) {
          dfs(board, r, c, true);
        }
      }
    }
  }

  public void dfs(char[][] board, int row, int col, boolean flip) {
    if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col] == true
        || board[row][col] == 'X') {
      return;
    }
    if (flip) {
      board[row][col] = 'X';
    }
    visited[row][col] = true;
    dfs(board, row + 1, col, flip);
    dfs(board, row - 1, col, flip);
    dfs(board, row, col + 1, flip);
    dfs(board, row, col - 1, flip);
  }
}