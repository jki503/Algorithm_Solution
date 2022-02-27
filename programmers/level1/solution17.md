# 프로그래머스 LEVEL 1 월간 코드 챌린지 시즌 2 약수의 개수와 덧셈

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/77884?language=java)

</br>

```java

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left ; i <= right ; i++)
            if(i % Math.sqrt(i) == 0)
                answer -=i;
            else
                answer +=i;

        return answer;
    }
}

```
