# leetcode 35. Search Insert Position

- [문제 링크](https://leetcode.com/problems/search-insert-position/submissions/)

</br>

```java

class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length;

        while(start < end){

            int mid = (start + end) / 2;

            if(nums[mid] >= target)
                end = mid;
            else
                start = mid + 1;


        }

        return start;
    }
}

```
