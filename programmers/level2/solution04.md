# 프로그래머스 LEVEL 2 위클리 챌린지 전력망을 둘로 나누기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/86971?language=java)

</br>

```java
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;

        for(int i = 0 ; i < wires.length; i++){
            int count1 = bfs(i , n, wires);
            int count2 = n - count1;

            answer = Math.min(answer, getAbs(count1 - count2));

        }
        return answer;
    }

    private int bfs(int cut, int n, int[][] wires){
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0 ; i < wires.length; i++){
            if(i == cut){
                continue;
            }

            int from = wires[i][0];
            int to = wires[i][1];

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(visited[curr]){
                continue;
            }

            visited[curr] = true;
            count+=1;

            for(int next : graph.getOrDefault(curr, new ArrayList<>())){
                q.offer(next);
            }
        }

        return count;
    }

    private int getAbs(int num){
        return num < 0 ? -num : num;
    }
}

```
