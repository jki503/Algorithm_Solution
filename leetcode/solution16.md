# leetcode 33. Search in Rotated Sorted Array

- [문제 링크](https://leetcode.com/problems/search-in-rotated-sorted-array/)

</br>

```java

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {

        int pivotNum = nums[0];

        int pivot = 0;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        // 피봇 찾기
        while(start <= end){

            mid = (start + end) / 2;

            if(pivotNum <= nums[mid]){
                pivot = mid;
                start = mid + 1;
            }
            else end = mid -1;
        }

        System.out.println(pivot);

        int resultIdx=-1;

        // 피봇을 기준으로 이분탐색
        if(nums[0] <= target && target <= nums[pivot])
            resultIdx = binarySearch(target,nums,0,pivot);
        else if(pivot < nums.length - 1 && nums[pivot+1] <= target && target <= nums[nums.length-1])
            resultIdx = binarySearch(target,nums,pivot+1,nums.length-1);


        return resultIdx;
    }

    private int binarySearch(int target, int[] nums, int start, int end){

        while(start <= end){

            int mid = (start + end) / 2;

            if(target == nums[mid])
                return mid;
            else if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;

        }

        return -1;
    }
}

```
