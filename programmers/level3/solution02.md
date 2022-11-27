# 프로그래머스 LEVEL 3 가장 먼 노드

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/49189?language=java)

```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        int[] counts = new int[n + 1];

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] e : edge){
            int from = e[0];
            int to = e[1];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        q.offer(1);

        int cnt = 0;
        while(!q.isEmpty()){

            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int node = q.poll();
                counts[node] = cnt;

                if(graph.get(node) == null){
                    continue;
                }

                for(Integer nextNode : graph.get(node)){
                    if(visited[nextNode]){
                        continue;
                    }
                    visited[nextNode] = true;
                    q.offer(nextNode);
                }
            }

            cnt++;
        }

        cnt-=1;

        for(int i = 2; i <= n; i++){
            if(counts[i] == cnt){
                answer++;
            }
        }

        return answer;
    }
}

```
