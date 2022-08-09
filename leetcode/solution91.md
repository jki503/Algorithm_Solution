# 300. Longest Increasing Subsequence

- [문제 링크](https://leetcode.com/problems/longest-increasing-subsequence/)

```java

class Solution {
    public int lengthOfLIS(int[] nums) {
        int answer = 0;

        int n = nums.length;
        int[] dp = new int[n];

        for(int num : nums){
            int pos = lowerBound(dp, num, answer - 1);

            if(pos < 0){
                pos = -pos - 1;
            }

            dp[pos] = num;

            if(pos == answer){
                answer++;
            }
        }

        return answer;
    }

    private int lowerBound(int arr[], int target, int end){
        int start = 0;

        while(start <= end){
            int mid = (end - start) / 2 + start;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] < target){
                start = mid + 1;
                continue;
            }

            end = mid - 1;
        }

        return -start-1;
    }
}

```
