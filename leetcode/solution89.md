# 310. Minimum Height Trees

- [문제 링크](https://leetcode.com/problems/minimum-height-trees/submissions/)

```java
import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
       if(n == 1){
            return Collections.singletonList(0);
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int from = e[0];
            int to = e[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        int[] degree = new int[n];
        for(int i = 0; i< n; i++){
            degree[i] = graph.get(i).size();
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(graph.get(i).size() == 1){
                q.offer(i);
            }
        }

        int cnt = n;
        while(cnt > 2){
            int len = q.size();
            cnt -= len;

            for(int i = 0 ; i < len; i++){
                int node = q.poll();
                for(int next : graph.get(node)){
                    degree[next]--;
                    if(degree[next] == 1){
                        q.offer(next);
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}
```
