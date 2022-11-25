# 프로그래머스 LEVEL 3 카운트 다운

- [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131129)

```java
class Solution {

    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];

        for(int i = 1; i <= target; i++){
            if(i <= 20 || i == 50){
                dp[i][0] = 1;
                dp[i][1] = 1;
                continue;
            }

            if(i <= 60 && i % 3 == 0){
                dp[i][0] = 1;
                dp[i][1] = 0;
                continue;
            }

            if(i <= 40 && i % 2 == 0){
                dp[i][0] = 1;
                dp[i][1] = 0;
                continue;
            }

            if(i > 50 && i <= 70){
                dp[i][0] = 2;
                dp[i][1] = 2;
                continue;
            }

            if(i < 70){
                if(i < 40){
                    dp[i][0] = 2;
                    dp[i][1] = 2;
                }
                else{
                    dp[i][0] = 2;
                    dp[i][1] = 1;
                }
                continue;
            }

            if(dp[i - 60][0] == dp[i - 50][0]){
                dp[i][0] = dp[i - 50][0] + 1;
                dp[i][1] = Math.max(dp[i - 60][1], dp[i - 50][1] + 1);
            }
            else if(dp[i - 60][0] < dp[i - 50][0]){
                dp[i][0] = dp[i - 60][0] + 1;
                dp[i][1] = dp[i - 60][1];
            }
            else{
                dp[i][0] = dp[i - 50][0] + 1;
                dp[i][1] = dp[i - 50][1] + 1;
            }
        }


        return new int[]{dp[target][0],dp[target][1]};
    }
}
```
