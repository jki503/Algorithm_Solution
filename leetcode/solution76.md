# leetcode 1710. Maximum Units on a Truck

- [문제 링크](https://leetcode.com/problems/maximum-units-on-a-truck/)

```java
import java.util.*;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int answer = 0;

        Arrays.sort(boxTypes, (b1, b2) -> b2[1] - b1[1]);

        for(int i = 0; i < boxTypes.length; i++){
            int[] curr = boxTypes[i];
            answer += curr[1] * (truckSize > curr[0] ? curr[0] : truckSize);
            truckSize = truckSize > curr[0] ? truckSize - curr[0] : 0;
            if(truckSize == 0)
                break;
        }

        return answer;
    }
}
```
