# 프로그래머스 LEVEL 3 2018 KAKAO BLIND RECRUITMENT [1차] 추석 트래픽

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17676?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;

class Solution {


    int[] starts;
    int[] ends;
    int n;

    public int solution(String[] lines) {
        int answer = 0;


        n = lines.length;

        starts = new int[n];
        ends = new int[n];

        int cnt=0;

        // start, end ms 설정
        setMs(lines);

        // 시작 기준
        for(int i=0; i< n; i++){
            int startMs = starts[i];
            int endMs = startMs + 1000;

            cnt = getMaxTraffic(startMs, endMs);
            answer = cnt > answer ? cnt : answer;
        }

        // 끝 기준
        for(int i=0;i<n;i++){
            int startMs = ends[i];
            int endMs = startMs + 1000;

            cnt = getMaxTraffic(startMs, endMs);
            answer = cnt > answer ? cnt : answer;
        }

        return answer;
    }

    private int getMaxTraffic(int startMs, int endMs){

        int cnt = 0;

        for(int i=0; i < n; i++){

            // 1번
            if( (starts[i] >= startMs && starts[i] < endMs) // 1. 시작점
              || (ends[i] >= startMs && ends[i] <endMs) // 2. 끝점
               ||(starts[i] <= startMs && ends[i] >= endMs) ) // 3. 포함
                cnt++;
            /* 2번 차이 알고 다시 re solution
            if(starts[i] >= startMs && starts[i] <= endMs
              || ends[i] >= startMs && ends[i] <= endMs)
                cnt++;
            */
        }

        return cnt;
    }

    private void setMs(String[] lines){

        for(int i=0; i < n; i++){

            int startMs = 0;
            int endMs = 0;

            String[] data = lines[i].split(" ");

            String[] times = data[1].split(":");

            endMs += ( Integer.parseInt(times[0]) * 3600 * 1000
                      + Integer.parseInt(times[1]) * 60 * 1000
                      + (int)(Double.parseDouble(times[2]) * 1000) );

            startMs = endMs - (int)(Double.parseDouble(data[2].substring(0,data[2].length()-1)) * 1000) +1;

            starts[i] = startMs;
            ends[i] = endMs;
        }
    }

}

```
