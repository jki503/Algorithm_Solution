# 프로그래머스 LEVEL 3 스티커 모으기(2)

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12971?language=java)

</br>

```java

class Solution {
    public int solution(int sticker[]) {
        int n = sticker.length;

        if(n == 1)
            return sticker[0];
        else if(n == 2)
            return sticker[0] > sticker[1] ? sticker[0] : sticker[1];
        else if(n == 3)
            return sticker[0] + sticker[2] > sticker[1] ? sticker[0] + sticker[2] : sticker[1];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = sticker[0];
        dp1[1] = sticker[1];
        dp1[2] = dp1[0] + sticker[2];
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];

        for(int i = 3; i < n; i++){
            dp1[i] = sticker[i] + Math.max(dp1[i - 3], dp1[i - 2]);
            dp2[i] = sticker[i] + Math.max(dp2[i - 3], dp2[i - 2]);
        }

        return Math.max(Math.max(dp1[n-3],dp1[n-2]),Math.max(dp2[n-2],dp2[n-1]));
    }
}

```
