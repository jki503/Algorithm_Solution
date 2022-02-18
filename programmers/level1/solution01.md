# 프로그래머스 LEVEL 1 2022 KAKAO BLIND RECRUITMENT 신고 결과 받기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/92334?language=java)

</br>

```java

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String,HashSet<String>> repMap = new HashMap<>();
        Map<String,Integer> cntMap = new HashMap<>();

        for(String id : id_list)
            repMap.put(id,new HashSet<>());

        // 신고 유저
        for(String r : report){

            String[] strs = r.split(" ");

            String from = strs[0];
            String to = strs[1];

            // 중복 신고가 아니면
            if(repMap.get(from).add(to))
                cntMap.put(to, cntMap.getOrDefault(to,0) + 1);

        }

        // 신고 한 유저 중 정지 아닌 유저 정리
        for(String r : report){

            String[] strs = r.split(" ");

            String from = strs[0];
            String to = strs[1];

            // 정지 유저면
            if(cntMap.get(to) >= k)
                continue;

            repMap.get(from).remove(to);
        }

        for(int i=0;i<id_list.length;i++){
            String id = id_list[i];
            answer[i] = repMap.get(id).size();
        }

        return answer;
    }
}

```
