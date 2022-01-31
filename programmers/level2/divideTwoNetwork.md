# 프로그래머스 LEVEL 2 위클리 챌린지 전력망을 둘로 나누기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/86971?language=java)

</br>

```java
import java.util.*;
import java.lang.Math;

class Solution {


    boolean[] visited;

    public int solution(int n, int[][] wires) {
        int answer = n;
        visited = new boolean[n+1];

        ArrayList[] adjList= new ArrayList[n+1];

        // i는 자를 wire
        for(int i=0;i<wires.length;i++){

            // 전력망 개수
            int countNetwork1 = resultedByCuttingWire(i,n,wires);
            int countNetwork2 = n - countNetwork1;

            answer = Math.min(answer, Math.abs(countNetwork1 - countNetwork2));

            // 방문 초기화
            Arrays.fill(visited,false);
        }


        return answer;
    }

    public int resultedByCuttingWire(int cut, int n, int[][]wires){

        // return 전력망1의 개수 : Int value of countNetwork1
        int count=0;

        ArrayList<Integer>[] adjList = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=0;i<wires.length;i++){

            // i가 자를 wire면 continue;
            if(i == cut)
                continue;

            int from = wires[i][0];
            int to = wires[i][1];

            adjList[from].add(to);
            adjList[to].add(from);

        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);



        while(!queue.isEmpty()){
            int currTower = queue.poll();

            // 방문한 송전탑이면 continue;
            if(visited[currTower])
                continue;

            // 방문과 count 갱신
            visited[currTower] = true;
            count+=1;

            for(int i=0;i<adjList[currTower].size();i++){
                queue.offer(adjList[currTower].get(i));
            }
        }

        return count;
    }
}

```
