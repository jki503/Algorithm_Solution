# 백준 문자열 지옥에 빠진 호석이(20166)

- [문제 링크](https://www.acmicpc.net/problem/20166)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  // 상 우 하 좌 상우 하좌 하우 상좌
  private static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};

  private static int[] dy = {-1, 0, 1, 0, -1, 1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    char[][] board = new char[n][m];
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      board[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < k; i++) {
      String target = br.readLine();
      if (map.containsKey(target)) {
        bw.write(map.get(target) + "\n");
        continue;
      }

      int totalCount = 0;
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < m; x++) {
          if (target.charAt(0) == board[y][x]) {
            totalCount += getCount(x, y, n, m, board, target.toCharArray());
          }
        }
      }
      map.put(target, totalCount);
      bw.write(totalCount + "\n");
    }

    bw.flush();
    bw.close();
  }

  private static int getCount(int x, int y, int nRow, int nCol, char[][] board, char[] targets) {
    int count = 0;

    Queue<Node> q = new ArrayDeque<>();
    q.offer(new Node(x, y, 0));

    while (!q.isEmpty()) {
      Node curr = q.poll();
      int currX = curr.x;
      int currY = curr.y;
      int currIdx = curr.idx;

      if (currIdx == targets.length - 1) {
        count++;
        continue;
      }

      for (int i = 0; i < dx.length; i++) {
        int nextX = getIndex(currX + dx[i], nCol);
        int nextY = getIndex(currY + dy[i], nRow);
        int nextIdx = currIdx + 1;
        if (board[nextY][nextX] == targets[nextIdx]) {
          q.offer(new Node(nextX, nextY, nextIdx));
        }
      }
    }

    return count;
  }

  private static int getIndex(int idx, int length) {
    if (idx < 0) {
      return length - 1;
    }

    if (idx >= length) {
      return 0;
    }

    return idx;
  }

  private static class Node {

    int x;

    int y;

    int idx;

    public Node(int x, int y, int idx) {
      this.x = x;
      this.y = y;
      this.idx = idx;
    }
  }
}

```
