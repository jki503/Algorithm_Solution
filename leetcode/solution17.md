# leetcode 17. Kth Largest Element in an Array

- [문제 링크](https://leetcode.com/problems/kth-largest-element-in-an-array/)

</br>

```java

import java.util.Arrays;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}

```
