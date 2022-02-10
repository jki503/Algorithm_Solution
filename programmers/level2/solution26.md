# 프로그래머스 LEVEL 2 2022 KAKAO BLIND RECRUITMENT 주차 요금 계산

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/92341?language=java)

</br>

```java

import java.util.*;
import java.lang.Math;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        /*
            parkingMap : 차 - 주차 시각
            timeMap : 차 - 이용한 시간
        */
        HashMap<String, Integer> parkingMap = new HashMap<>();
        HashMap<String, Integer> timeMap = new HashMap<>();

        for(String record : records){
            String[] r = record.split(" ");

            // 시간, 차, 상태
            int time = getMinute(r[0]);
            String car = r[1];
            String status = r[2];


            if(status.equals("IN")){
                // 입차
                parkingMap.put(car,time);
            }
            else{
                /*출차
                    이용시간 = time - parking 시간
                    현재 차의 이용 시간 갱신 후
                    parkingMap의 car 삭제
                */

                int usingTime = time - parkingMap.get(car);
                timeMap.put(car,timeMap.getOrDefault(car,0) + usingTime);
                parkingMap.remove(car);
            }
        }

        // 출차하지 않은 차량 이용 시간 갱신
        for(Map.Entry<String,Integer> entry : parkingMap.entrySet()){

            String car = entry.getKey();
            int time = entry.getValue();
            int usingTime = (23*60+59) - time;

            timeMap.put(car, timeMap.getOrDefault(car,0)+usingTime);
        }

        // 차량 넘버 오름차순
        List<String> cars = new ArrayList<>(timeMap.keySet());
        Collections.sort(cars);
        answer = new int[cars.size()];

        // 이용 요금 계산
        for(int i=0;i<cars.size();i++){

            int usingTime = timeMap.get(cars.get(i));
            answer[i] = calcFee(usingTime,fees);
        }

        return answer;
    }

    public int calcFee(int t, int[] f){

        // 기본 시간을 기준으로 : f[0]
        return t < f[0] ? f[1] : f[1] + (int)Math.ceil((t-f[0])*1.0 / f[2]) * f[3];
    }

    // 차 시간을 분으로
    public int getMinute(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}

```
