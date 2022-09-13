# 프로그래머스 LEVEL 3 2021 KAKAO BLIND RECRUITMENT 합승 택시 요금

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72413?language=java)

</br>

- 다익스트라

```java
import java.util.*;

class Solution {
    private Map<Integer, List<Point>> graph = new HashMap<>();
    
    // index a = 0, b = 1, s = 2;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        setGraph(fares);
        
        int[][] costs = new int[3][n + 1];
        int[] starts = new int[]{a,b,s};
        
        for(int i = 0; i < 3; i++){
            Arrays.fill(costs[i], Integer.MAX_VALUE);              
        }
        
        for(int i = 0; i < 3; i++){
           setCosts(starts[i], costs[i]);
        }
        
        for(int i = 1; i < n + 1; i++){
            int sum = 0;
            for(int j = 0; j < 3; j++){
                sum += costs[j][i];
            }
            
            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
    
    private void setCosts(int start, int[] costFromStart){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start, 0));
        
        while(!pq.isEmpty()){
            Point curr = pq.poll();
            int num = curr.num;
            int cost = curr.cost;
            
            if(cost >= costFromStart[num]){
                continue;
            }  
            
            costFromStart[num] = cost;
                            
            for(Point next : graph.get(num)){
                pq.offer(new Point(next.num, cost + next.cost));
            }
        }
    }
    
    private void setGraph(int[][] fares){
        for(int[] f : fares){
            int from = f[0];
            int to = f[1];
            int cost = f[2];
            
            graph.computeIfAbsent(from, k -> new ArrayList()).add(new Point(to, cost));
            graph.computeIfAbsent(to, k -> new ArrayList()).add(new Point(from, cost));
        }       
    }
    
    class Point implements Comparable<Point>{
        int num;
        int cost;
        
        public Point(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
        
        public int compareTo(Point p){
            return this.cost - p.cost;
        }
    }
}
```

</br>
</br>
</br>

- 플로이드 와샬

```java

import java.util.Arrays;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] costMap = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            Arrays.fill(costMap[i],20000001);
            costMap[i][i] = 0;
        }


        for(int[] f : fares){
            int from = f[0];
            int to = f[1];
            int cost = f[2];

            costMap[from][to] = cost;
            costMap[to][from] = cost;
        }

        for(int k=1;k<=n;k++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    costMap[i][j] = Math.min(costMap[i][j],costMap[i][k] + costMap[k][j]);

        answer = costMap[s][a] + costMap[s][b]; // 합승 X

        // 합승
        for(int i=1;i<=n;i++)
            answer = Math.min(answer, costMap[s][i] + costMap[i][a] + costMap[i][b]);

        return answer;
    }
}

```
