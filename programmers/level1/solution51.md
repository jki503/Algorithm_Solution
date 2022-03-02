# 프로그래머스 LEVEL 1 핸드폰 번호 가리기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12948?language=java)

</br>

```java

class Solution {
    public String solution(String phone_number) {

        StringBuilder sb = new StringBuilder();

        int n = phone_number.length();

        for(int i=0; i < n-4; i++)
            sb.append('*');

        // 뒷 4자리
        sb.append(phone_number.substring(n-4,n));

        return sb.toString();
    }
}

```
