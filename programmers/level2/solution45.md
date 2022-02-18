# 프로그래머스 LEVEL 2 피보나치 수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12945?language=java)

</br>

```java

class Solution {

    final int MOD = 1234567;

    public int solution(int n) {
        int answer = 0;

        int[] f = new int[n+1];

        f[0] = 0;
        f[1] = 1;

        for(int i=2;i<=n;i++){
            f[i] = (f[i-1] + f[i-2]) % MOD;
        }

        answer = f[n];

        return answer;
    }
}

```
