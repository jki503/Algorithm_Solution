# 프로그래머스 LEVEL 3 월간 코드 챌린지 시즌 2 모두 0으로 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/76503?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    long answer;
    int n;
    long[] w;
    int root;


    // 인접리스트
    List<Integer>[] adj;
    boolean[] visited;
    int[] indegree;

    public long solution(int[] a, int[][] edges) {
        answer = 0;
        root = 0;

        n = a.length;
        w = new long[n];

        // weight 초기화
        for(int i=0; i < n ;i++){
            w[i] = a[i];
            answer+=w[i];
        }

        // 합이 0이 아니거나 legnth가 2일때
        if(answer != 0) return -1;
        if(n==2) return Math.abs(w[0]);

        // 인접리스트 정보 설정
        initEdgeData(edges);

        // bfs 탐색
        leafToRoot();

        return answer;
    }


    // leaf -> root로 bfs
    public void leafToRoot(){

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1 ; i < n ; i++){
            // leaf 추가
            if(adj[i].size() == 1){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){

            int leaf = queue.poll();

            answer += Math.abs(w[leaf]);

            indegree[leaf]-=1;

            for(int parent : adj[leaf]){

                // 올라 갈 수 없으면
                if(indegree[parent] == 0)
                    continue;

                indegree[parent]-=1;
                w[parent] += w[leaf];

                // 올라갈 수 있는 경우만
                if(indegree[parent]==1){

                    // root면
                    if(parent == root)
                        continue;

                    queue.offer(parent);
                }

            }
        }
    }


    // 인접리스트 정보
    public void initEdgeData(int[][] arr){

        adj = new ArrayList[n];
        visited= new boolean[n];
        indegree = new int[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] e : arr){
            int from = e[0];
            int to = e[1];

            adj[from].add(to);
            adj[to].add(from);

            indegree[from]+=1;
            indegree[to]+=1;
        }
    }

}

```
