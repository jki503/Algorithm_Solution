# 프로그래머스 LEVEL 1 시저 암호

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12926?language=java)

</br>

```java

class Solution {
    public String solution(String s, int n) {

        StringBuilder sb= new StringBuilder();

        for(char c : s.toCharArray()){

            // 공백
            if(c==' '){
                sb.append(' ');
                continue;
            }

            if((c>='a' && c <='z') && c+n > 'z'
                || (c >='A' && c <='Z') && c+n > 'Z' )
                sb.append((char)(c+n-26));
            else
                sb.append((char)(c+n));

        }

        return sb.toString();
    }
}

```
