# 프로그래머스 LEVEL 1 2016년

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12901?language=java)

</br>

```java

class Solution {

    private final int[] Month = {31,29,31,30,31,30,31,31,30,31,30,31};
    private final String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

    public String solution(int a, int b) {
        String answer = "";

        int init = 5; // 1월 1일 금요일
        int total = 0;

        for(int i=0;i < a - 1; i++)
            total+=Month[i];

        total+=b-1;

        answer = day [(init+total) % 7];


        return answer;
    }
}

```
