# 프로그래머스 LEVEL 1 월간 코드 챌린지 시즌3 없는 숫자 더하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/86051?language=java)

</br>

```java

class Solution {
    public int solution(int[] numbers) {
        int answer = 9*(9+1) / 2;

        for(int n : numbers)
            answer-=n;

        return answer;
    }
}


```
