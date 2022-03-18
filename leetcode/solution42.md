# leetcode

- [문제 링크]()

</br>

```java

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1,o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        Stack<int[]> stack = new Stack<>();

        stack.push(intervals[0]);

        for(int i=1; i< intervals.length; i++){

            int[] curr = intervals[i];

            int[] prev = stack.peek();

            if(prev[1] < curr[0])
                stack.push(curr); // not overlapping
            else{

                if(prev[1] < curr[1]){ // overlapping
                    stack.pop();
                    stack.push(new int[]{prev[0],curr[1]});
                }
            }

        }

        int[][] result = new int[stack.size()][2];

        for(int i = result.length-1 ; i>= 0 ; i--)
            result[i] = stack.pop();

        return result;
    }
}

```
