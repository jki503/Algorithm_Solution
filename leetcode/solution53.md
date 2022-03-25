# leetcode 1029. Two City Scheduling

- [문제 링크](https://leetcode.com/problems/two-city-scheduling/submissions/)

```java

import java.util.Arrays;

class Solution {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (c1,c2) -> (c1[0] - c1[1]) < (c2[0] - c2[1]) ? -1 : 1);

        int result = 0;
        int n = costs.length / 2;

        for(int[] c : costs){

            if(n-- > 0)
                result += c[0];
            else
                result += c[1];

        }

        return result;
    }
}

```
