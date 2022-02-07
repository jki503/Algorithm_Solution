# 프로그래머스 LEVEL 3 최고의 집합

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12938?language=java)

</br>

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {

        // 존재 하지 않을 경우
        if(n > s)
            return new int[] {-1};

        int[] answer = new int [n];
        Arrays.fill(answer, s/n);


        // 나머지 answer에 뒷부분부터 1씩 더하기

        for(int j=1;j<=s%n;j++){
            answer[n-j]+=1;
        }

        return answer;
    }
}

```
