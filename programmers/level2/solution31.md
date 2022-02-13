# 프로그래머스 LEVEL 2 2021 KAKAO BLIND RECRUITMENT 순위 검색

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72412?language=java)

</br>

```java

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

class Solution {

    HashMap<String,List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        map = new HashMap<>();

        // 2^4 조합
        for(String inf : info){
            String[] curr = inf.split(" ");

            comb(curr);
        }

        // score 기준 정렬
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            Collections.sort(entry.getValue());
        }

        // 조회
        for(int i=0;i<query.length;i++){
            String[] curr = query[i].replaceAll("\\sand\\s|\\-","").split(" ");
            String key = curr[0];
            int score = Integer.parseInt(curr[1]);

            answer[i] = lowerBound(key, score);
        }

        return answer;
    }


    // info에 대해 충족하는 모든 쿼리 조합 - 2^4
    public void comb(String[] arr){
        int score = Integer.parseInt(arr[arr.length-1]);

        // 전체 부분집합 score 이전까지만 [0-3]
        for(int i=1;i <= (1 <<arr.length-1);i++){
            StringBuilder key = new StringBuilder();

            for(int j=0;j<arr.length-1;j++){
                if( (i & (1<<j)) > 0){
                    key.append(arr[j]);
                }
            }
            // key가 없으면 list 생성 후 추가
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(score);
        }
    }


    // binarySearch lowerBound
    public int lowerBound(String key, int score){
        List<Integer> list = map.getOrDefault(key,new ArrayList<>());

        int start = 0;
        int end = list.size();

        while(start < end){
            int mid = (start + end) / 2;

            if(list.get(mid) >= score){
                end = mid;
            }
            else
                start = mid+1;

        }
        // score 이상인 개수
        return list.size() - start;
    }
}

```
