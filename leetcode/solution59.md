# leetcode 287. Find the Duplicate Number

- [문제 링크](https://leetcode.com/problems/find-the-duplicate-number/)

</br>

```java

import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        int result = 0;

        for(int i=1 ; i < nums.length; i++)
            if(nums[i] == nums[i-1]){
                result = nums[i];
                break;
            }


        return result;
    }
}

```
