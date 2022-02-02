# 프로그래머스 LEVEL 2 [Summer/Winter Coding(~2018)] 배달

</br>

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12978?language=java)

- [다익스트라와 플로이드와샬](https://github.com/jki503/CS_for-tech-interview/tree/main/algorithm#algorithm)

</br>

- 다익스트라 알고리즘

</br>

```java
import java.util.*;

class Solution {

    public static class Node implements Comparable<Node>{
        int num;
        int cost;

        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }

        // 최소비용 우선순위
        @Override
        public int compareTo(Node node){
            return this.cost < node.cost ? -1 : 1;
        }

    }


    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        //  1=< K <= 500,000
        int MAX = 500001;

        // start -> node cost 저장
        int start = 1;
        int costArr[] = new int[N+1];
        Arrays.fill(costArr,MAX);

        // 인접리스트 세팅
        ArrayList<Node>[] adjList = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            adjList[from].add(new Node(to, cost));
            adjList[to].add(new Node(from, cost));
        }

        // heap
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currentNum = node.num;
            int currentCost = node.cost;

            // 현재 경로기준으로
            // 최소 비용 아니면 continue
            if(costArr[currentNum] < currentCost)
                continue;
            costArr[currentNum] = currentCost;

            for(int i=0;i<adjList[currentNum].size();i++){
                int nextNum = adjList[currentNum].get(i).num;
                int nextCost = adjList[currentNum].get(i).cost + currentCost;
                    pq.offer(new Node(nextNum, nextCost));

            }
        }

        // K 이하의 경과시간인 노드
        for(int i=1;i<=N;i++){
            if(costArr[i] <=K)
                answer++;
        }

        return answer;
    }
}
```

- 플로이드 와샬 알고리즘

</br>

```java
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // start: 시작 노드
        // MAX : 1<=k<=500000
        int start = 1;
        int MAX = 500001;

        // 인접행렬 설정
        int costMap[][] = new int[N+1][N+1];
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                costMap[i][j] = MAX;

        for(int i=0;i<road.length;i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];

            //경로 여러 개일 경우
            // 입출력 예시 2번 3-> 5
            costMap[from][to] = Integer.min(costMap[from][to],cost);
            costMap[to][from] = Integer.min(costMap[to][from],cost);
        }


        // 경유 노드
        for(int k = 1 ; k <= N ; k++){
            // 출발 노드
            for(int i=1 ; i <= N ; i++){
                // 도착 노드
                for(int j=1 ; j <= N ; j++){

                    // 출발 도착 같으면
                    if(i == j){
                        costMap[i][j] = 0;
                        continue;
                    }

                    // 경로가 없으면
                    if(costMap[i][k] == MAX || costMap[k][j] == MAX)
                        continue;

                    // cost 갱신
                    if(costMap[i][j] > costMap[i][k] + costMap[k][j]){
                        costMap[i][j] = costMap[i][k] + costMap[k][j];
                    }
                }
            }
        }

        for(int i=1; i <= N ; i++){
            System.out.println(costMap[start][i]);
            if(costMap[start][i] <=K){
                answer++;
            }
        }

        return answer;
    }
}
```
