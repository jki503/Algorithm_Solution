# 프로그래머스 LEVEL 2 기능 개발

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42586?language=java)

</br>

```java

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<progresses.length;i++){

            //날짜 계산
            int day = (100 - progresses[i]) / speeds[i];

            if((100 - progresses[i]) % speeds[i] != 0)
                day+=1;


            if(!queue.isEmpty() && queue.peek() < day){
                // 기능이 배포가 가능할 경우 개수 추가
                list.add(queue.size());
                queue.clear();
            }

            queue.offer(day);
        }

        // 마지막 기능 개수 추가
        list.add(queue.size());
        queue.clear();

        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}

```
