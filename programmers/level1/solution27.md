# 프로그래머스 LEVEL 1 가운데 글자 가져오기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12903?language=java)

</br>

```java

class Solution {
    public String solution(String s) {
        String answer = "";

        int n = s.length();
        int mid = n/2;

        if(n % 2 == 0)
            answer = s.substring(mid-1,mid+1);
        else
            answer += s.charAt(mid);


        return answer;
    }
}

```
