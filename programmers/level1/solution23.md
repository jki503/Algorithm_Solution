# 프로그래머스 LEVEL 1 월간 코드 챌린지 시즌 3 나머지가 1이 되는 수 찾기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/87389?language=java)

</br>

```java

class Solution {
    public int solution(int n) {
        int answer = 2;

        while(true){

            if(n % answer == 1)
                break;

            answer+=1;
        }

        return answer;
    }
}

```
