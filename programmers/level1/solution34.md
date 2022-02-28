# 프로그래머스 LEVEL 1 문자열 다루기 기본

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12918?language=java)

</br>

```java

class Solution {
    /*
    public boolean solution(String s) {

        int n = s.length();

        // 길이 조건
        if(n != 4 && n != 6)
            return false;

        s = s.replaceAll("[^0-9]","");

        // 문자 지운후 길이 체크
        if(n != s.length())
            return false;

        return true;
    }*/

    public boolean solution(String s){

        int n = s.length();

         // 길이 조건
        if(n != 4 && n != 6)
            return false;

        for(char c : s.toCharArray())
            if(! (c >='0' && c<='9'))
                return false;

        return true;
    }
}

```
