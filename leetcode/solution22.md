# leetcode 238. Product of Array Except Self

- [문제 링크](https://leetcode.com/problems/product-of-array-except-self/submissions/)

</br>

```java

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int total = 1; // product except 0
        List<Integer> zeroList = new ArrayList<>(); //index of zero

        int n = nums.length;
        int[] answer = new int[n];

        for(int i=0; i < n; i++)
            if(nums[i] == 0) zeroList.add(i);
            else total*=nums[i];

        int zeroCnt = zeroList.size();

        if(zeroCnt == 0){ // no contains zero
           for(int i=0; i < n ; i++)
                answer[i] = total / nums[i];
        }
        else if(zeroCnt == 1){ // only one zero

            for(int idx : zeroList)
                answer[idx] = total;
        }
        // if nums have 2 and more zero return default answer

        return answer;
    }
}

```
