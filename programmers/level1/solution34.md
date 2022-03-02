# 프로그래머스 LEVEL 1 문자열 다루기 기본

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12918?language=java)

</br>

```java

import java.util.regex.Pattern;

class Solution {
    public boolean solution(String s) {
        return s.matches("\\d{4}{6}");
    }
}

```
