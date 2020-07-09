import java.util.LinkedList;

public class ShortestPath {
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
    int m = grid.length, n = grid[0].length;
    LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
    queue.add(new Pair<>(0, 0));
    int pathLength = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      pathLength++;
      while (size-- > 0) {
        Pair<Integer, Integer> curBlk = queue.poll();
        int curRow = curBlk.getKey(), curCol = curBlk.getValue();
        if (grid[curRow][curCol] == 1) {
          continue;
        }
        if (curRow == m - 1 && curCol == n - 1) {
          return pathLength;
        }
        grid[curRow][curCol] = 1;// 标记, 防止在BFS中重复运算
        for (int[] d : dir) {
          int newRow = curRow - d[0];
          int newCol = curCol - d[1];
          if (newRow >= m || newRow < 0 || newCol >= n || newCol < 0) {
            continue;
          } else {
            queue.add(new Pair<>(newRow, newCol));
          }
        }
      }
    }
    return -1;
  }
}

class Pair<Key, Value> {
  private int x;
  private int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getKey() {
    return x;
  }

  public int getValue() {
    return y;
  }
}

// https://leetcode.com/problems/shortest-path-in-binary-matrix/