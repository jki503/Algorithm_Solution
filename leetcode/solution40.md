# leetcode 26. Remove Duplicates from Sorted Array

- [문제 링크](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

</br>

```java

class Solution {
    public int removeDuplicates(int[] nums) {

        int idx = 1;

        for(int i=1;i<nums.length;i++)
            if(nums[i-1] != nums[i])
                nums[idx++] = nums[i];

        return idx;
    }
}

```
