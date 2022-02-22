# 프로그래머스 LEVEL 3 야근 지수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12927?language=java)

</br>

```java

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int w : works)
            pq.offer(w);

        // 작업량 계산
        for(int i=0 ; i < n; i++){
            int w = pq.poll()-1;

            // 남은 작업량 없음으로
            if(w < 0)
                break;

            pq.offer(w);

        }
        while(!pq.isEmpty())
            answer += Math.pow(pq.poll(),2);

        return answer;
    }
}

```
