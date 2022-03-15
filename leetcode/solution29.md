# leetcode 347. Top K Frequent Elements

- [문제 링크](https://leetcode.com/problems/top-k-frequent-elements/)

</br>

```java

import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] > o2[1] ? -1: 1);
        Map<Integer,Integer> fMap = new HashMap<>();

        for(int num : nums)
            fMap.put(num, fMap.getOrDefault(num,0)+1);

        for(Map.Entry<Integer,Integer> entry : fMap.entrySet())
            pq.offer(new int[]{entry.getKey(), entry.getValue()});

        for(int i=0; i < k; i++)
            result[i] = pq.poll()[0];

        return result;
    }
}

```
