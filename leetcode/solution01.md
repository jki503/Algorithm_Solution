# leetcode 1. Two Sum

- [문제 링크](https://leetcode.com/problems/two-sum/)

</br>

```java

import java.util.Map;
import java.util.HashMap;


class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        Map<Integer,Integer> idxMap = new HashMap<>();

        for(int i=0; i < nums.length; i++){

            int need = target - nums[i];

            // find need
            if(idxMap.containsKey(need)){
                result[0] = i;
                result[1] = idxMap.get(need);
                break;
            }

            idxMap.put(nums[i],i);

        }


        return result;
    }
}

```
