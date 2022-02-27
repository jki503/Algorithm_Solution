# 프로그래머스 LEVEL 1 월간 코드 챌린지 시즌1 내적

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/70128?language=java)

</br>

```java

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;

        for(int i=0; i < a.length; i++)
            answer += a[i] * b[i];

        return answer;
    }
}

```
