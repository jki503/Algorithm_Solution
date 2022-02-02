# 프로그래머스 LEVEL 2 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72411?language=java)

</br>

```java

import java.util.*;
import java.lang.Math;

class Solution {

    HashMap<String, Integer> map;
    StringBuilder sb;


    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> list = new ArrayList<>();

         map = new HashMap<>();

        // 조합을 위한 order 원소 정렬
        for(int i=0 ; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for(int i=0;i<course.length;i++){

            map = new HashMap<>();
            int max = 0;

            for(int j=0;j<orders.length;j++){

                // course의 개수가 더 클 경우 continue;
                if(orders[j].length() < course[i])
                    continue;

                sb= new StringBuilder();
                combination(orders[j],0,0,course[i]);

            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }

            // 2명 이상의 주문이 아니면
            if(max < 2)
                continue;

            // max와 같으면 list 추가
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() == max)
                    list.add(entry.getKey());
            }

        }

        answer = new String[list.size()];
        for(int i = 0 ; i < list.size();i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    // nCr 조합
    public void combination(String o, int start, int count, int r){

        // 종료 조건
        if(count == r){
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0) + 1);
            return;
        }

        for(int i=start; i < o.length(); i++){
            sb.append(o.charAt(i));
            combination(o,i+1,count+1,r);
            sb.delete(count,count+1);
        }
    }
}


```
