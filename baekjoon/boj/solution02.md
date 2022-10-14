# 키 순서(2458)

- [문제 링크](https://www.acmicpc.net/problem/2458)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int answer = 0;
    boolean[][] board = new boolean[n][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int loser = Integer.parseInt(st.nextToken()) - 1;
      int winner = Integer.parseInt(st.nextToken()) - 1;

      board[winner][loser] = true;
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == k) {
            continue;
          }

          if (board[i][j]) {
            continue;
          }

          board[i][j] = board[i][k] && board[k][j];
        }
      }
    }

    for (int y = 0; y < n; y++) {
      int cnt = 0;
      for (int x = 0; x < n; x++) {
        if (board[y][x] || board[x][y]) {
          cnt++;
        }
      }
      if (cnt == n - 1) {
        answer++;
      }
    }

    bw.write(String.valueOf(answer));
    bw.flush();
    bw.close();
  }
}

```
