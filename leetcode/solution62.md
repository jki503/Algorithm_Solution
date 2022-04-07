# leetcode 1046. Last Stone Weight

- [문제 링크](https://leetcode.com/problems/last-stone-weight/)

```java

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int s : stones)
            pq.add(s);

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(first > second)
                pq.offer(first - second);
        }

        if(pq.isEmpty())
            return 0;
        else
            return pq.poll();

    }
}

```
