# leetcode 128. Longest Consecutive Sequence

- [문제 링크](https://leetcode.com/problems/longest-consecutive-sequence/)

```java
import java.util.*;

class Solution {

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        int answer = 0;
        int temp = 1;
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                temp++;
            }
            else if(nums[i] - nums[i-1] == 0){
                continue;
            }
            else{
                answer = Math.max(temp,answer);
                temp = 1;
            }
        }

        answer = Math.max(answer, temp);

        return answer;
    }
}
```
