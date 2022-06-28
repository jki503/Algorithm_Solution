# leetcode 41. First Missing Positive

- [문제 링크](https://leetcode.com/problems/first-missing-positive/)

```java
import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int answer = 1;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num <= 0)
                continue;

            set.add(num);
        }

        while(set.contains(answer)){
            answer++;
        }

        return answer;
    }
}
```
