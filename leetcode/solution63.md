# leetcode 1695. Maximum Erasure Value

- [문제 링크](https://leetcode.com/problems/maximum-erasure-value/)

</br>

```java
import java.util.*;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int result = 0;
        int sum = 0;
        int j = 0;


        for(int i = 0; i < n ; i++){
            int num = nums[i];
            sum += num;

            map.put(num, map.getOrDefault(num, 0) + 1);

            while(map.get(num) > 1){
                int curr = nums[j];
                map.put(curr, map.get(curr) - 1);
                sum -= curr;
                j++;
            }

            result = result < sum ? sum : result;
        }

        return result;
    }
}
```
