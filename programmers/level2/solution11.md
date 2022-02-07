# 프로그래머스 LEVEL 2 위장

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42578?language=java)

</br>

```java

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();

        // 옷 종류 counting
        for(int i=0;i<clothes.length;i++){
            String category = clothes[i][1];

            map.put(category,map.getOrDefault(category,0)+1);
        }

        // 옷을 벗을 수 있는 경우 + 1
        for(Entry<String,Integer> entry : map.entrySet()){
            answer *= (entry.getValue()+1);
        }

        // 옷을 다벗는 경우 제외
        answer-=1;


        return answer;
    }
}

```
