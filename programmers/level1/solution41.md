# 프로그래머스 LEVEL 1 자릿수 더하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12931?language=java)

</br>

```java

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(true){

            if(n==0)
                break;

            answer += n%10;
            n/=10;
        }

        return answer;
    }
}

```
