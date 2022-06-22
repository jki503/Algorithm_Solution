# leetcode 1642. Furthest Building You Can Reach

- [문제 링크](https://leetcode.com/problems/furthest-building-you-can-reach/)

```java
import java.util.*;

class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int size = heights.length;

        while(i < size - 1){
            int diff = heights[i + 1] - heights[i];

            if(diff > 0){
                // 다리를 쓸 수 있을때
                if(bricks >= diff){
                    bricks -= diff;
                    pq.offer(diff);
                }
                else{
                    if(ladders > 0){
                        ladders--;

                        // 이전 높이가 더 높다면
                        if(!pq.isEmpty() && pq.peek() > diff){
                            bricks += pq.poll() - diff;
                            pq.offer(diff);
                        }

                    }
                    else{
                        break;
                    }
                }
            }

            i++;
        }

        return i;
    }

}
```
