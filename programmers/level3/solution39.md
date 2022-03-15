# 프로그래머스 LEVEL 3 디스크 컨트롤러

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42627)

</br>

```java

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {

        int answer = 0;
        int n = jobs.length;
        int end = 0;
        int cnt = 0;
        int idx = 0; // jobs index

        // 요청시간 순
        Arrays.sort(jobs, (j1,j2) -> j1[0] - j2[0] < 0 ? -1 : 1);

        // 소요시간 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1] < 0 ? -1 : 1);

        while(cnt < n){

            // 종료 시간 이전까지 들어오는 작업 넣기
            while(idx < n && jobs[idx][0] <=end)
                pq.offer(jobs[idx++]);

            if(pq.isEmpty())
                end = jobs[idx][0];
            else{
                int[] curr = pq.poll();
                answer += curr[1] + end - curr[0];
                end += curr[1];
                cnt++;
            }

        }


        return answer/n;
    }
}

```
