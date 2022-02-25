# 프로그래머스 LEVEL 1 2021 카카오 채용연계형 인턴십 숫자 문자열과 영단어

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/81301?language=java)

</br>

```java

class Solution {

    final String[] engNums = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public int solution(String s) {
        int answer = 0;

        for(int i=0;i<engNums.length;i++)
            s = s.replace(engNums[i],Integer.toString(i));

        answer = Integer.parseInt(s);

        return answer;
    }
}

```
