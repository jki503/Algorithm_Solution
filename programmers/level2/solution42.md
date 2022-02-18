# 프로그래머스 LEVEL 2 숫자의 표현

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12924?language=java)

</br>

```java

class Solution {
    public int solution(int n) {
        int answer = 1;

        int num = 1;
        int sum = 0;

        for(int i = 1 ; i <= (n+1) / 2; i++){
            sum+=i;

            // 비교 할 필요 없을때
            if(sum < n)
                continue;

            // 빼서 비교 하기
            while(sum > n)
                sum -= num++;

            if(sum == n)
                answer++;

        }

        return answer;
    }
}

```
