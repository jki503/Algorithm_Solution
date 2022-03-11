# leetcode 15. 3sum

- [문제 링크](https://leetcode.com/problems/3sum/submissions/)

</br>

```java

import java.util.Arrays;

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0 ; i < n-2 ; i++){

            // 중복 제거
            if(i > 0 && nums[i-1] == nums[i])
                continue;

            int l = i + 1;
            int r = n - 1;

            while( l< r){

                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0){

                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while(l < r && nums[l-1] == nums[l]) l++;
                    while(l < r && nums[r+1] == nums[r]) r--;
                }
                else if(sum > 0) r--;
                else l++;
            }

        }


        return list;
    }
}

```
