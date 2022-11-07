# BOJ 알파벳(1987)

- [문제 링크](https://www.acmicpc.net/problem/1987)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  private static int answer = 0;

  //상 우 하 좌
  private static final int[] dx = new int[]{0, 1, 0, -1};
  private static final int[] dy = new int[]{-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    char[][] board = new char[r][c];
    for (int y = 0; y < r; y++) {
      board[y] = br.readLine().toCharArray();
    }

    boolean[] historySet = new boolean[26];
    historySet[board[0][0] - 'A'] = true;
    dfs(0, 0, 1, board, historySet);

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }

  private static void dfs(int x, int y, int count, char[][] board, boolean[] historySet) {
    answer = Math.max(answer, count);

    for (int i = 0; i < 4; i++) {
      int xx = x + dx[i];
      int yy = y + dy[i];

      if (xx < 0 || xx >= board[0].length || yy < 0 || yy >= board.length) {
        continue;
      }

      if (historySet[board[yy][xx] - 'A']) {
        continue;
      }

      historySet[board[yy][xx] - 'A'] = true;
      dfs(xx, yy, count + 1, board, historySet);
      historySet[board[yy][xx] - 'A'] = false;
    }
  }

}

```
