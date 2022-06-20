# 백준 class 3 토마토(7569)

- [문제 링크](https://www.acmicpc.net/problem/7569)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Point {

  int x;
  int y;
  int z;

  public Point(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

public class Main {


  private static final int dx[] = {0, 0, 0, 1, 0, -1};
  private static final int dy[] = {0, 0, -1, 0, 1, 0};
  private static final int dz[] = {-1, 1, 0, 0, 0, 0};


  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input[] = br.readLine().split(" ");
    int m = Integer.parseInt(input[0]);
    int n = Integer.parseInt(input[1]);
    int h = Integer.parseInt(input[2]);
    int board[][][] = new int[h][n][m];
    Queue<Point> q = new LinkedList<>();

    int result = 0;
    int notTomato = 0;

    for (int z = 0; z < h; z++) {
      for (int y = 0; y < n; y++) {
        input = br.readLine().split(" ");
        for (int x = 0; x < m; x++) {
          board[z][y][x] = Integer.parseInt(input[x]);

          if (board[z][y][x] == 0) {
            notTomato++;
          }

          if (board[z][y][x] == 1) {
            q.add(new Point(x, y, z));
          }
        }
      }
    }

    while (notTomato > 0 && !q.isEmpty()) {
      int size = q.size();

      for (int i = 0; i < size; i++) {
        Point point = q.poll();
        int x = point.x;
        int y = point.y;
        int z = point.z;

        for (int j = 0; j < 6; j++) {
          int xx = x + dx[j];
          int yy = y + dy[j];
          int zz = z + dz[j];

          // 인덱스를 초과하면
          if (xx < 0 || yy < 0 || zz < 0 || xx >= m || yy >= n || zz >= h) {
            continue;
          }

          // 익을 수 없다면
          if (board[zz][yy][xx] != 0) {
            continue;
          }

          notTomato--;
          board[zz][yy][xx] = 1;
          q.add(new Point(xx, yy, zz));
        }
      }
      result++;
    }

    if (notTomato != 0) {
      result = -1;
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

}
```
