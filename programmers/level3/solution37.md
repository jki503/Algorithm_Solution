# 프로그래머스 LEVEL 3 멀리 뛰기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12914?language=java)

</br>

```java

class Solution {

    private static final int MOD = 1234567;

    public long solution(int n) {

        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++)
            dp[i] += (dp[i-1] + dp[i-2]) % MOD;


        return dp[n];
    }
}

```
