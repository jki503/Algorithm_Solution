# 2022 KAKAO TECH INTERNSHIP 두 큐 합 같게 만들기

- [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/118667)

```java
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for(int num : queue1){
            sum1 += num;
            q1.offer(num);
        }

        for(int num : queue2){
            sum2 += num;
            q2.offer(num);
        }

        int limit = queue1.length * 2 * 2;
        int cnt = 0;
        while(sum1 != sum2){
            cnt++;
            if(sum1 > sum2){
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            }
            else{
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }

            if(cnt > limit){
                return -1;
            }
        }

        return cnt;
    }
}
```
