# 프로그래머스 LEVEL 1 완주하지 못한 선수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42576?language=java)

</br>

```java

import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();

        // 참가자 정리
        for(String p : participant)
            map.put(p, map.getOrDefault(p,0)+1);

        // 완주자 정리
        for(String c : completion)
            map.put(c, map.get(c) - 1);

        // 미완주자 찾기
        for(Entry<String,Integer> entry : map.entrySet())
            if(entry.getValue() > 0)
                answer = entry.getKey();

        return answer;
    }
}

```
