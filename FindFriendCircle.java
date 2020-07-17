public class FindFriendCircle {
  boolean hasVisited[];

  public int findCircleNum(int[][] M) {
    int n = M.length;
    int count = 0;
    hasVisited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!hasVisited[i]) {
        findFriends(M, i);
        count++;
      }
    }
    return count;
  }

  public void findFriends(int[][] M, int i) {
    for (int j = 0; j < M.length; j++) {
      if (M[i][j] == 1 & !hasVisited[j]) {
        hasVisited[j] = true;
        findFriends(M, j);
      }
    }
  }
}