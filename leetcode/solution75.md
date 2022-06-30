# leetcode 462. Minimum Moves to Equal Array Elements II

- [문제 링크](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)

```java
import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        int answer = 0;
        int n = nums.length;
        if(n < 2)
            return answer;

        Arrays.sort(nums);
        int mid = (nums[(n - 1) / 2]+ nums[n / 2]) / 2;

        for(int num : nums){
            int diff = mid - num;
            diff *= diff < 0 ? -1 : 1;
            answer += diff;
        }

        return answer;
    }
}
```
