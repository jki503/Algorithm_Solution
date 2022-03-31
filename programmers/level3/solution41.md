# 프로그래머스 LEVEL 3 줄 서는 방법

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12936?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> personList = new ArrayList<>();
        long[] factorial = new long[n+1];

        factorial[0]= 1;
        k--;
        for(int i = 1; i <= n; i++){
            personList.add(i);
            factorial[i] = factorial[i-1] * i;
        }

        int idx = 0;
        while(n>0){

            int person = (int)(k / factorial[n-1]);

            answer[idx++] = personList.get(person);
            personList.remove(person);
            k %= factorial[n-1];
            n--;
        }

        return answer;
    }

}

```
