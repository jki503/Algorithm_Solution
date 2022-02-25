# 프로그래머스 LEVEL 1 2021 KAKAO BLIND RECRUITMENT 신규 아이디 추천

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72410?language=java#)

</br>

```java

class Solution {
    public String solution(String new_id) {
        String answer = "";

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        // 3단계
        new_id = new_id.replaceAll("\\.{2,}",".");

        // 4단계
        new_id = new_id.replaceAll("^(\\.)|(\\.)$","");

        // 5단계
        if(new_id.length() == 0)
            new_id = "a";

        // 6단계
        if(new_id.length() >= 16)
            new_id = new_id.substring(0,15).replaceAll("(\\.)$","");

        // 7단계
        while(new_id.length() < 3)
            new_id += new_id.charAt(new_id.length()-1);

        answer = new_id;

        return answer;
    }
}

```
