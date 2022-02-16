# 프로그래머스 LEVEL 3 2018 KAKAO BLIND RECRUITMENT [1차] 셔틀버스

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17678?language=java)

</br>

```java

import java.util.PriorityQueue;

class Solution {


    PriorityQueue<Integer> pq;

    public String solution(int n, int t, int m, String[] timetable) {

        String answer = "";

        pq = new PriorityQueue<>();

        // 분으로 변환
        for(String time : timetable){
            pq.offer(getMinute(time));
        }

        // 마지막 시간
        int result = getLast(n,m,t);

        // 시간 -> 문자열로 변환
        answer = getTimeString(result);

        return answer;
    }

    public int getLast(int n, int m, int t){

        int start = 9 * 60;
        int result = 0;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){

            // 크루 수
            cnt = 0;

            while(!pq.isEmpty()){

                int curr = pq.peek();

                // 크루 먼저 보낼 수 있으면
                if(curr <= start && cnt < m){
                    pq.poll();
                    cnt++;
                }else break;

                // 마지막 사람 - 1
                result = curr - 1;
            }
            // 다음 버스
            start += t;
        }


        // 마지막 버스를 탈 수 있으면
        if(cnt < m){

            result = start - t;
        }

        return result;
    }

    public int getMinute(String t){
        return Integer.parseInt(t.substring(0,2)) * 60
            + Integer.parseInt(t.substring(3));
    }

    public String getTimeString(int t){
          return String.format("%02d",t/60)
              + ":" + String.format("%02d",t%60);
    }
}

```
