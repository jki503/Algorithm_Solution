# 프로그래머스 LEVEL 2 2021 KAKAO BLIND RECRUITMENT 메뉴 리뉴얼

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/72411?language=java)

</br>

```java

import java.util.*;
import java.lang.Math;

class Solution {
import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for(int c : course){
            Map<String, Integer> map = new HashMap<>();
            int max = 0;

            for(int i = 0; i < orders.length; i++){
                char[] arr = orders[i].toCharArray();
                Arrays.sort(arr);
                orders[i] = String.valueOf(arr);

                if(orders[i].length() < c){
                    continue;
                }
                combinate(orders[i], 0 , 0, c, new StringBuilder(), map);
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max, entry.getValue());
            }

            if(max < 2){
                continue;
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    list.add(entry.getKey());
                }
            }
        }

        String[] answer = new String[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private void combinate(String o, int start, int cnt, int k, StringBuilder sb, Map<String, Integer> map){
        if(cnt == k){
            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }

        for(int i = start; i < o.length(); i++){
            sb.append(o.charAt(i));
            combinate(o,i+1,cnt+1,k, sb, map);
            sb.delete(cnt,cnt+1);
        }
    }
}
```
