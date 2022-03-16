# leetcoe 239. Sliding Window Maximum

- [문제 링크](https://leetcode.com/problems/sliding-window-maximum/)

```java

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] result = new int[n-k+1];

        int max = Integer.MIN_VALUE;
        int idx = 0; // max num idx

        for(int i=0;i<k;i++){
            if(max <= nums[i]){
                max = nums[i];
                idx = i;
            }
        }

        result[0] = max;

        for(int i=k ; i < nums.length;i++){


            if(idx == i-k){
                // renewal check
                max = Integer.MIN_VALUE;
                for(int j=i-k+1;j<=i;j++)
                    if(max <= nums[j]){
                        max = nums[j];
                        idx = j;
                    }
            }
            else{
                if(nums[i] >= max){
                    max = nums[i];
                    idx = i;
                }
            }

            result[i-k+1] = max;
        }

        return result;
    }
}

```
