# 프로그래머스 LEVEL 1 정수 제곱근 판별

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12934?language=java)

</br>

```java

class Solution {
    public long solution(long n) {
        long answer = 0;

        long sqrt = (long)Math.sqrt(n);

        if(n ==  sqrt * sqrt)
            answer = (sqrt+1) * (sqrt+1);
        else
            answer = -1;

        return answer;
    }
}

```
