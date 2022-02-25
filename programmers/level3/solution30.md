# 프로그래머스 LEVEL 3 2021 KAKAO BLIND RECRUITMENT 광고 삽입

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72414?language=java)

</br>

```java

class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);

        int[] total = new int[playTime+1];

        // 시간 정리
        for(String log : logs){
            String[] times = log.split("-");
            int start = timeToInt(times[0]);
            int end = timeToInt(times[1]);

            total[start] += 1;
            total[end] -= 1;
        }

        // 누적
        for(int i=1;i<playTime;i++){
            total[i] += total[i-1];
        }

        // 최대 시간 찾기
        long sum=0;
        long maxSum = 0;
        int maxTime = 0;

        for(int i=0;i<advTime;i++){
            sum+=total[i];
        }

        maxSum = sum;

        for(int i = advTime; i < playTime; i++){

            sum += total[i] - total[i-advTime];

            // 최대 시간 갱신
            if(sum > maxSum){
                maxSum = sum;
                maxTime = i - advTime + 1;
            }
        }

        answer = timeToString(maxTime);

        return answer;
    }

    private int timeToInt(String time){

        String[] t = time.split(":");

        return Integer.parseInt(t[0]) * 3600 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
    }

    private String timeToString(int time){

        int hours = time / 3600;
        time%=3600;

        int minutes = time / 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }
}

```
