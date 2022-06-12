# leetcode 1695. Maximum Erasure Value

- [문제 링크](https://leetcode.com/problems/maximum-erasure-value/)

</br>

```java
import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int result = 0;
        int sum = 0;
        int left = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length ; i++){
            int num = nums[i];
            sum += num;

            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > 1)
            {
                while(map.get(num) > 1){
                    System.out.println(nums[left]);

                    map.put(nums[left], map.get(nums[left]) - 1);
                    sum -= nums[left];
                    left++;
                }
            }

            result = result < sum ? sum : result;
        }

        return result;
    }
}
```
