package leetcode;

import java.util.List;

public class KeysAndRooms {

  private boolean[] visited;

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    int N = rooms.size();
    visited = new boolean[N];

    dfs(0, rooms);

    for (boolean b : visited) {
      if (!b) {
        return false;
      }
    }

    return true;
  }

  private void dfs(int index, List<List<Integer>> rooms) {
    if (visited[index]) {
      return;
    }

    visited[index] = true;

    for (Integer keyIndex : rooms.get(index)) {
      dfs(keyIndex, rooms);
    }
  }
}
