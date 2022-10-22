# 백준 월드컵(6987)

- [문제 링크](https://www.acmicpc.net/problem/6987)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  private static final int TOTAL_MATCH_COUNT = 15;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] combinations = new int[TOTAL_MATCH_COUNT][2];
    int match = 0;
    for (int from = 0; from < 6; from++) {
      for (int to = from + 1; to < 6; to++) {
        combinations[match][0] = from;
        combinations[match][1] = to;
        match++;
      }
    }

    int[] answer = new int[4];
    int idx = 0;
    StringTokenizer st;
    while (idx < 4) {
      st = new StringTokenizer(br.readLine());
      boolean available = true;

      int[][] matches = new int[6][3];
      for (int i = 0; i < 6; i++) {
        matches[i][0] = Integer.parseInt(st.nextToken());
        matches[i][1] = Integer.parseInt(st.nextToken());
        matches[i][2] = Integer.parseInt(st.nextToken());

        if (matches[i][0] + matches[i][1] + matches[i][2] != 5) {
          available = false;
          break;
        }
      }

      if (available) {
        backTracking(0, matches, combinations, idx, answer);
      }
      idx++;
    }

    for (int i = 0; i < 4; i++) {
      bw.write(answer[i] + " ");
    }

    bw.flush();
    bw.close();
  }

  private static void backTracking(int matchCount, int[][] matches,
      int[][] combinations, int idx, int[] answer) {
    if (matchCount == TOTAL_MATCH_COUNT) {
      answer[idx] = 1;
      return;
    }

    int from = combinations[matchCount][0];
    int to = combinations[matchCount][1];

    // from 기준 승리
    if (matches[from][0] > 0 && matches[to][2] > 0) {
      matches[from][0]--;
      matches[to][2]--;
      backTracking(matchCount + 1, matches, combinations, idx, answer);
      matches[from][0]++;
      matches[to][2]++;
    }

    // from 기준 무승부
    if (matches[from][1] > 0 && matches[to][1] > 0) {
      matches[from][1]--;
      matches[to][1]--;
      backTracking(matchCount + 1, matches, combinations, idx, answer);
      matches[from][1]++;
      matches[to][1]++;
    }

    // from 기준 패배
    if (matches[from][2] > 0 && matches[to][0] > 0) {
      matches[from][2]--;
      matches[to][0]--;
      backTracking(matchCount + 1, matches, combinations, idx, answer);
      matches[from][2]++;
      matches[to][0]++;
    }
  }
}
```
