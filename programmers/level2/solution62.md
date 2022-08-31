# 프로그래머스 Level 2 모음사전

- [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512)

```java
class Solution {
    public int solution(String word) {
        int answer = 0;
        int total = 3905;
        String aeiou = "AEIOU";

        for(String str : word.split("")){
            total/=5;
            answer += total * aeiou.indexOf(str) + 1;
        }

        return answer;
    }
}
```
