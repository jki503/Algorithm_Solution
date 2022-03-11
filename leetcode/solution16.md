# leetcode 16. 16. 3Sum Closest

- [문제 링크](https://leetcode.com/problems/3sum-closest/)

</br>

```java

import java.util.Arrays;


class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int result = 0;
        int min = Integer.MAX_VALUE;

        Arrays.sort(nums);

        int n = nums.length;

        for(int i=0; i < n-2;i++){

            int l = i+1;
            int r = n-1;

            while(l < r){

                int sum = nums[i] + nums[l] + nums[r];

                int diff = target - sum;
                int absDiff =  diff < 0 ? -diff : diff;

                if(absDiff < min){
                    min = absDiff;
                    result = sum;
                }

                if(absDiff == 0)
                    return result;

                if(diff > 0 )
                    l++;
                else
                    r--;

            }

        }

        return result;
    }
}

```
