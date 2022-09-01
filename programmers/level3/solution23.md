# 프로그래머스 LEVEL 3 월간 코드 챌린지 시즌 2 모두 0으로 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/76503?language=java)

</br>

```java

import java.util.*;

class Solution {

    private int root = 0;

    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        int n = a.length;

        long[] w = new long[n];
        for(int i = 0 ; i < n ; i++){
            w[i] = a[i];
            answer += w[i];
        }

        if(answer != 0){
            return -1;
        }

        if(n == 2){
            return Math.abs(a[0]);
        }

        int[] degrees = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            int from = e[0];
            int to = e[1];
            degrees[from]++;
            degrees[to]++;

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < n; i++){
            if(degrees[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int leaf = q.poll();
            answer += (long)Math.abs(w[leaf]);
            degrees[leaf]--;

            for(int parent : graph.get(leaf)){
                if(degrees[parent] == 0){
                    continue;
                }

                degrees[parent]--;
                w[parent] += w[leaf];
                if(degrees[parent] == 1){
                    if(parent == root){
                        continue;
                    }

                    q.offer(parent);
                }
            }
        }

        return answer;
    }
}
```
