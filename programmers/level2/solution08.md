# 프로그래머스 LEVEL2 더 맵게

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42626?language=java)

</br>

```java

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville){
            pq.offer(s);
        }

        while(true){

            // 탈출 조건
            if(pq.peek() >= K)
                break;

            // 만들 수 없는 경우
            if(pq.size() <2){
                answer = -1;
                break;
            }

            // 가장 맵지 않은
            int first = pq.poll();

            // 두번 째로 매운
            int second = pq.poll();

            pq.offer(first + second*2);
            answer++;
        }

        return answer;
    }
}

```
