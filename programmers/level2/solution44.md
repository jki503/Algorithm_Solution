# 프로그래머스 LEVEL 2 JadenCase 문자열 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12951?language=java)

</br>

```java

class Solution {
    public String solution(String s) {

        String answer = "";
        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();
        boolean isPrefix = true;

        for(char c : s.toCharArray()){

            if(c == ' '){
                isPrefix = true;
                sb.append(c);
                continue;
            }

            if(isPrefix){
                c = Character.toUpperCase(c);
                isPrefix = false;
            }

            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}

```
