# 프로그래머스 LEVEL 2 숫자 블럭

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12923?language=java)

```java
import java.util.List;
import java.util.ArrayList;


class Solution {

    private static final int MAX = 10000000;

    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

       for(int i = 0; i < size; i++){
           answer[i] = findMin(begin + i);
       }

        return answer;
    }

    private int findMin(long num){
        if(num == 1)
            return 0;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0 && (num/i) <= MAX){
                return (int)num/i;
            }
        }

        return 1;
    }
}



```
