# leetcode 1658. Minimum Operations to Reduce X to Zero

- [문제 링크](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/submissions/)

```java
class Solution {
    public int minOperations(int[] nums, int x) {

        int subLength = -1;
        int n = nums.length;
        int total = 0;

        for(int num : nums)
            total += num;

        if(total < x)
            return -1;

        int target = total - x;

        int i = 0;
        int j = 0;
        int sum = 0;

        while(i < n){
            sum += nums[i];

            if(sum == target){
                subLength = Math.max(subLength, i - j + 1);
            }
            else if(sum > target){
                while(j <= i && sum > target)
                    sum -= nums[j++];

                if(sum == target)
                    subLength = Math.max(subLength, i - j + 1);
            }
            i++;
        }

        return subLength == -1 ? -1 : n - subLength;
    }
}
```
