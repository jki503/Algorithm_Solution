# 프로그래머스 LEVEL 1 x만큼 간격이 있는 n개의 숫자

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12954?language=java)

</br>

```java

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long gap = x;

        for(int i=0;i<n;i++)
            answer[i] = gap * (i+1);

        return answer;
    }
}

```
