# 백준 강의실 배정(11000)

- [문제 링크](https://www.acmicpc.net/problem/11000)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st;
    PriorityQueue<Schedule> schedulePq = new PriorityQueue<>();
    PriorityQueue<Integer> endPq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      schedulePq.offer(new Schedule(start, end));
    }

    endPq.offer(schedulePq.poll().end);
    while (!schedulePq.isEmpty()) {
      Schedule curr = schedulePq.poll();
      if (curr.start >= endPq.peek()) {
        endPq.poll();
      }
      endPq.offer(curr.end);
    }

    bw.write(String.valueOf(endPq.size()));
    bw.flush();
    bw.close();
  }

  private static class Schedule implements Comparable<Schedule> {

    int start;

    int end;

    public Schedule(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Schedule schedule) {
      return this.start - schedule.start;
    }

  }
}
```
