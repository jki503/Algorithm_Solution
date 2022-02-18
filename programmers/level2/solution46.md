# 프로그래머스 LEVEL 2 최솟값 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12941?language=java)

</br>

```java

import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<n;i++){
            answer += A[i] * B[n-1-i];
        }

        return answer;
    }
}

```
