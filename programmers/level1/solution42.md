# 프로그래머스 LEVEL 1 자연수 뒤집어 배열로 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12932?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(long n) {

        List<Integer> list = new ArrayList<>();

        while(true){

            if(n==0)
                break;

            list.add((int)(n % 10));

            n/=10;
        }

        int[] answer = new int[list.size()];

        for(int i = 0 ; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}

```
