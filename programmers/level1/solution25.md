# 프로그래머스 LEVEL 1 문자열 내 p와 y의 개수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12916?language=java)

</br>

```java

class Solution {
    boolean solution(String s) {

        boolean answer = true;

        int cntP = 0;
        int cntY = 0;

        for(char c : s.toCharArray()){

            if(c == 'y' || c == 'Y')
                cntY++;
            else if(c == 'p' || c == 'P')
                cntP++;

        }

        answer = cntP == cntY ? true : false;

        return answer;
    }
}

```
