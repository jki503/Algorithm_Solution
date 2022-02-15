# 프로그래머스 LEVEL 2 구명 보트

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42885?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;
        int max = people.length - 1;

        while(min<=max){

            // 두 명 구출
            if(people[min] + people[max] <= limit)
                min++;

            // 한 명만 구출
            max--;
            answer++;
        }

        return answer;
    }
}

```
