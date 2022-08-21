# 1338. Reduce Array Size to The Half

- [문제 링크](https://leetcode.com/problems/reduce-array-size-to-the-half/)

```java
import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        int answer = 0;
        int half = arr.length / 2;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int currSize = 0;

        while(currSize < half){
            currSize += pq.poll();
            answer++;
        }

        return answer;
    }
}
```
