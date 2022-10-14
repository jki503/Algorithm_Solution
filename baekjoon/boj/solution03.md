# 백준 특정 거리의 도시 찾기(18352)

- [문제 링크](https://www.acmicpc.net/problem/18352)

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    Map<Integer, List<Node>> graph = new HashMap<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());

      graph.computeIfAbsent(from, v -> new ArrayList<>()).add(new Node(to, 1));
    }

    int[] costs = new int[n + 1];
    Arrays.fill(costs, Integer.MAX_VALUE);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(x, 0));

    List<Integer> answer = new ArrayList<>();
    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      int num = curr.num;
      int cost = curr.cost;

      if (cost >= costs[num]) {
        continue;
      }

      costs[num] = cost;

      if (costs[num] == k) {
        answer.add(num);
        continue;
      }

      if(graph.get(num) == null){
        continue;
      }

      for (Node next : graph.get(num)) {
        pq.offer(new Node(next.num, cost + next.cost));
      }
    }

    if (answer.size() == 0) {
      bw.write("-1");
      bw.flush();
    } else {
      Collections.sort(answer);
      for (int num : answer) {
        bw.write(num + "\n");
        bw.flush();
      }
    }

    bw.close();
  }

  private static class Node implements Comparable<Node> {

    int num;
    int cost;

    public Node(int num, int cost) {
      this.num = num;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
      return this.cost - node.cost;
    }
  }

}
```
