# 프로그래머스 LEVEL 3 가장 먼 노드

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/49189?language=java)

---

</br>
</br>

- 풀이

---

```java
import java.util.*;

class Solution {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] distance = new int[n+1];
        boolean [] visited = new boolean[n+1];

        // 인접행렬 세팅
        ArrayList<Integer>[] adjList = (ArrayList<Integer>[])new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<edge.length;i++){
            adjList[edge[i][0]].add(edge[i][1]);
            adjList[edge[i][1]].add(edge[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i=0;i<adjList[node].size();i++){
                int nextNode = adjList[node].get(i);

                // 방문했는지
                if(!visited[nextNode]){
                    visited[nextNode]=true;
                    queue.offer(nextNode);
                    distance[nextNode] = distance[node] + 1;
                }
            }

        }

        //최댓값
        int maxDistance = Arrays
            .stream(distance)
            .max()
            .getAsInt();

        for(int i=1; i<distance.length;i++){
            if(distance[i] == maxDistance)
                answer++;
        }

        return answer;
    }
}

```
