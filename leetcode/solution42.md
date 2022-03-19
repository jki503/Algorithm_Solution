# leetcode 56. Merge Intervals

- [문제 링크](https://leetcode.com/problems/merge-intervals/)

</br>

```java

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i< intervals.length; i++){

            int[] curr = intervals[i];

            if(end < curr[0]){
                list.add(new int[]{start,end}); // not overlapping
                start = curr[0];
                end = curr[1];
            }else{

                if(end < curr[1]){ // overlapping
                    end = curr[1];
                }
            }

        }
        list.add(new int[]{start,end});

        int[][] result = new int[list.size()][2];

        for(int i=0; i< list.size();i++)
            result[i] = list.get(i);

        return result;
    }
}

```
