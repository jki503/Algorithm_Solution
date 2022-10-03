# leetcode 207. Course Schedule

- [문제 링크](https://leetcode.com/problems/course-schedule/)

```java
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] degrees= new int[numCourses];

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] p : prerequisites){
            int after = p[0];
            int before = p[1];

            degrees[after]++;
            graph.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
        }

        for(int i = 0; i < degrees.length; i++){
            if(degrees[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            numCourses--;

            if(graph.get(curr) == null){
                continue;
            }

            for(int next : graph.get(curr)){
                degrees[next]--;
                if(degrees[next] == 0){
                    q.offer(next);
                }
            }
        }

        if(numCourses != 0){
            return false;
        }

        return true;
    }
}
```
