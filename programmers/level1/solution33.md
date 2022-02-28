# 프로그래머스 LEVEL 1 문자열 내림차순으로 배치하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12917?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public String solution(String s) {

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder(new String(arr));

        return sb.reverse().toString();
    }
}

```
