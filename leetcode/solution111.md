# leetcode 435. Non-overlapping Intervals

- [문제 링크](https://leetcode.com/problems/non-overlapping-intervals/)

```java
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o2[0] - o1[0];
            }

            return o1[1] - o2[1];
        });

        int cnt = 0;
        int last = Integer.MIN_VALUE;
        for(int[] i : intervals){
            if(last > i[0]){
                cnt++;
            }
            else{
                last = i[1];
            }
        }

        return cnt;
    }
}
```
