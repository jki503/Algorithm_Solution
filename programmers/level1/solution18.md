# 프로그래머스 LEVEL 1 Summer/Winter Coding(~2018) 예산

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12982?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for(int num : d){

            if(num <= budget){
                answer++;
                budget-=num;
            }
            else
                break;
        }


        return answer;
    }
}

```
