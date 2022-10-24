# 백준 운동(1956)

- [문제 링크](https://www.acmicpc.net/problem/1956)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final int INF = 4_000_001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    int[][] distances = new int[v + 1][v + 1];
    for (int i = 1; i <= v; i++) {
      Arrays.fill(distances[i], INF);
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int distance = Integer.parseInt(st.nextToken());

      distances[from][to] = distance;
    }

    for (int mid = 1; mid <= v; mid++) {
      for (int source = 1; source <= v; source++) {
        for (int destination = 1; destination <= v; destination++) {
          if (source == mid || mid == destination || source == destination) {
            continue;
          }

          if (distances[source][destination]
              <= distances[source][mid] + distances[mid][destination]) {
            continue;
          }

          distances[source][destination] = distances[source][mid] + distances[mid][destination];
        }
      }
    }

    int answer = INF;
    for (int source = 1; source <= v; source++) {
      for (int destination = 1; destination <= v; destination++) {
        if (source == destination) {
          continue;
        }

        answer = Math.min(answer, distances[source][destination] + distances[destination][source]);
      }
    }

    bw.write(String.valueOf(answer == INF ? -1 : answer));
    bw.flush();
    bw.close();
  }
}
```
