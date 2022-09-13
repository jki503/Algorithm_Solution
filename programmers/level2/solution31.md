# 프로그래머스 LEVEL 2 2021 KAKAO BLIND RECRUITMENT 순위 검색

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72412?language=java)

</br>

```java
import java.util.*;

class Solution {
    private Map<String,List<Integer>> infoMap = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int n = query.length;
        int[] answer = new int[n];

        for(String i : info){
            combinateSubSet(i.split(" "));
        }

        for(Map.Entry<String, List<Integer>> entry : infoMap.entrySet()){
            Collections.sort(entry.getValue());
        }

        for(int i = 0; i < n; i++){
            String[] q = query[i].replaceAll("\\sand\\s|-","")
                .split(" ");
            String key = q[0];
            int score = Integer.parseInt(q[1]);
            answer[i] = lowerBound(key, score);
        }

        return answer;
    }

    private void combinateSubSet(String[] arr){
        int score = Integer.parseInt(arr[arr.length - 1]);

        for(int i = 1 ; i <= (1  << arr.length - 1); i++){
            StringBuilder keySb = new StringBuilder();

            for(int j = 0; j < arr.length - 1; j++){
                if((i & 1 << j) > 0){
                    keySb.append(arr[j]);
                }
            }
            infoMap.computeIfAbsent(keySb.toString(), k -> new ArrayList<>()).add(score);
        }
    }

    private int lowerBound(String key, int score){
        List<Integer> list = infoMap.getOrDefault(key, new ArrayList<>());

        int start = 0;
        int end = list.size();

        while(start < end){
            int mid = (start + end) / 2;

            if(list.get(mid) >= score){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return list.size() - start;
    }
}
```
