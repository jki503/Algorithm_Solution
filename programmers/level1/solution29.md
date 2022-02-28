# 프로그래머스 LEVEL 1 두 정수 사이의 합

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12912?language=java)

</br>

```java

class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        int s =a;
        int e = b;

        if(a>b){
            s = b;
            e = a;
        }

        for(int i=s; i <= e;i++)
            answer += i;

        return answer;
    }
}

```
