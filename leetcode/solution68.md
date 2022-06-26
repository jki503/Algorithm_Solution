# leetcode 665. Non-decreasing Array

- [문제 링크](https://leetcode.com/problems/non-decreasing-array/)

```java
class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean isChanged = false;

        for(int i = 0 ; i < nums.length - 1; i++){

            if(nums[i] <= nums[i + 1]){
                continue;
            }

            //변경 체크, 변경이 두 번 일어나면 return false;
            if(isChanged)
                return false;

            if(i == 0 || nums[i-1] <= nums [i+1]){
                nums[i] = nums[i+1];
            }
            else{
                nums[i+1] = nums[i];
            }

            isChanged = true;

        }

        return true;
    }
}
```
