# 프로그래머스 LEVEL 3 입국심사

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/43238?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 0;
        long right = (long)n * times[times.length-1];

        while(left < right){

            long mid = (left + right) / 2;
            long cnt = 0;

            for(int t : times)
                cnt += (mid / t);

            if(cnt >= n)
                right = mid;
            else{
                left = mid + 1;
            }
        }

        return left;
    }
}

```
