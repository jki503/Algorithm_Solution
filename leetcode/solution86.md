# leetcode 34. Find First and Last Position of Element in Sorted Array

- [문제 링크](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {

        int start = lowerBound(target, nums);

        if(start ==  nums.length || nums[start] != target){
            return new int[]{-1, -1};
        }

        int end = lowerBound(target + 1, nums) - 1;

        return new int[]{start, end};
    }

    private int lowerBound(int num, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (num <= arr[mid] ) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        return start;
    }

}
```
