# leetcode 210. Course Schedule II

- [문제 링크](https://leetcode.com/problems/course-schedule-ii/)

```java
import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] answer = new int[numCourses];
        if(prerequisites.length == 0){
            for(int i = 0; i < answer.length; i++){
                answer[i] = i;
            }
            return answer;
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

        int i = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            numCourses--;
            answer[i++] = curr;

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
            return new int[]{};
        }

        return answer;
    }
}
```
