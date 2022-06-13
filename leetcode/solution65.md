# leetcode 120. Triangle

- [문제 링크](https://leetcode.com/problems/triangle/)

```java
import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for(int y = 1 ; y < n; y++){
            List<Integer> row = triangle.get(y);

            for(int x = 0 ; x < row.size(); x++){

                if(x > 0 && x < row.size() -1){
                    dp[y][x] += Math.min(dp[y-1][x],dp[y-1][x-1]) + triangle.get(y).get(x);
                }
                else if(x == 0){
                    dp[y][x] += dp[y-1][x] + triangle.get(y).get(x);
                }
                else if(x == row.size() - 1){
                    dp[y][x] += dp[y-1][x-1] + triangle.get(y).get(x);
                }
            }
        }

        Arrays.sort(dp[n-1]);

        return dp[n-1][0];
    }
}

```
