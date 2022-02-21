# 프로그래머스 LEVEL 3 2021 KAKAO BLIND RECRUITMENT 합승 택시 요금

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72413?language=java)

</br>

- 다익스트라

```java

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {

    ArrayList<ArrayList<Node>> graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        setGraph(n, fares);

        int[] fromA = new int[n+1];
        int[] fromB = new int[n+1];
        int[] fromS = new int[n+1];

        Arrays.fill(fromA, Integer.MAX_VALUE);
        Arrays.fill(fromB, Integer.MAX_VALUE);
        Arrays.fill(fromS, Integer.MAX_VALUE);

        fromA = getDist(a,fromA);
        fromB = getDist(b,fromB);
        fromS = getDist(s,fromS);

        // 각 노드로부터 최소 찾기
        for(int i=1;i<=n;i++)
            answer = Math.min(answer, fromA[i] + fromB[i] + fromS[i]);

        return answer;
    }

     public int[] getDist(int start, int[] costs){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){

            Node curr = pq.poll();

            int no = curr.no;
            int cost = curr.cost;

            // 최소 비용 아니면
            if(cost > costs[no])
                continue;

            // cost 갱신
            costs[no] = cost;

            ArrayList<Node> Nodes = graph.get(no);

            for(Node node : Nodes)
                pq.offer(new Node(node.no, cost + node.cost));

        }

        return costs;
    }

    public void setGraph(int n, int[][] data){

        graph = new ArrayList<>();

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<Node>());

        for(int[] f : data){
            int from = f[0];
            int to = f[1];
            int cost = f[2];

            graph.get(from).add(new Node(to,cost));
            graph.get(to).add(new Node(from,cost));
        }
    }

    class Node implements Comparable<Node>{

        int no;
        int cost;

        Node(int no, int cost){
            this.no = no;
            this.cost = cost;
        }

        public int compareTo(Node n){
            return this.cost - n.cost;
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
