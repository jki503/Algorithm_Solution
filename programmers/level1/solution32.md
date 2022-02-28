# 프로그래머스 LEVEL 1 문자열 내 마음대로 정렬하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12915?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1,s2)
                        -> s1.charAt(n) - s2.charAt(n) == 0 ? s1.compareTo(s2) : s1.charAt(n) - s2.charAt(n) );

        return strings;
    }
}

```
