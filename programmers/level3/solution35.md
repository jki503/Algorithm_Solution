# 프로그래머스 LEVEL 3 2020 카카오 인턴십 보석 쇼핑

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/67258?language=java)

</br>

```java

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;


class Solution {
    public int[] solution(String[] gems) {

        Map<String,Integer> gemMap = new HashMap<>();
        Set<String> typeSet = new HashSet<>(Arrays.asList(gems));
        Queue<String> q = new LinkedList<>();

        int gemCnt = typeSet.size(); // 보석 종류 개수

        int start = 0;
        int len = Integer.MAX_VALUE;
        int tempStart = 0;

        for(String gem : gems){

            // 보석 추가
            q.offer(gem);
            gemMap.put(gem, gemMap.getOrDefault(gem,0) + 1);

            // 필요없는 보석 제거
            while(true){

                String currGem = q.peek();

                if(gemMap.get(currGem) >= 2){
                    q.poll();
                    gemMap.put(currGem, gemMap.get(currGem) - 1);
                    tempStart++;
                }
                else
                    break;

            }

            // 최소 범위 체크 후 갱신
            if(gemCnt == gemMap.size() && len > q.size()){
                start = tempStart;
                len = q.size();
            }

        }


        int[] answer = {start+1, start+len};

        return answer;
    }
}

```
