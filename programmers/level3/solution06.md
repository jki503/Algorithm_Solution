# 프로그래머스 LEVEL 3 등굣길

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42898?language=java)

</br>

```java

class Solution {

    private static final int MODULAR = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[n + 1][m + 1];
        dp[1][1] = 1;

        for(int[] puddle : puddles){
            int y = puddle[1];
            int x = puddle[0];
            dp[y][x] = -1;
        }

        for(int y = 1; y <= n; y++){
            for(int x = 1; x <= m; x++){
                if(dp[y][x] == -1){
                    dp[y][x] = 0;
                    continue;
                }

                dp[y][x] += (dp[y][x - 1] + dp[y - 1][x]) % MODULAR;
            }
        }

        return dp[n][m];
    }
}

```
