# 프로그래머스 LEVEL 1 이상한 문자 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12930?language=java)

</br>

```java

class Solution {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        int idx = 0;

        for(char c : s.toCharArray()){

            if(c == ' '){
                idx=0;
                sb.append(c);
                continue;
            }

            if(idx % 2 == 0)
                c = Character.toUpperCase(c);
            else
                c = Character.toLowerCase(c);

            idx++;
            sb.append(c);
        }

        return sb.toString();
    }
}

```
