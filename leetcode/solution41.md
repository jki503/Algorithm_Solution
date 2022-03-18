# leetcode 283. Move Zeroes

- [문제 링크](https://leetcode.com/problems/move-zeroes/)

</br>

```java

class Solution {
    public void moveZeroes(int[] nums) {

        int idx = 0;

        for(int num : nums)
            if(num != 0)
                nums[idx++] = num;

        while(idx < nums.length)
            nums[idx++] = 0;

    }
}

```
