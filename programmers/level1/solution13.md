# 프로그래머스 LEVEL 1 모의고사

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42840?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;

class Solution {

    private final int[] person1 = {1,2,3,4,5};
    private final int[] person2 = {2,1,2,3,2,4,2,5};
    private final int[] person3 = {3,3,1,1,2,2,4,4,5,5};

    public int[] solution(int[] answers) {

        int[] cnt = new int[3];

        int n1 = person1.length;
        int n2 = person2.length;
        int n3 = person3.length;

        // 각 정답 개수
        for(int i = 0 ; i < answers.length ;i++){

            if(person1[i % n1] == answers[i]) cnt[0]++;
            if(person2[i % n2] == answers[i]) cnt[1]++;
            if(person3[i % n3] == answers[i]) cnt[2]++;

        }

        // 최대 개수
        int maxCnt = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);

        List<Integer> result = new ArrayList<>();

        // 가장 높은 점수 받은 사람
        for(int i = 0 ; i < 3; i++)
            if(maxCnt == cnt[i]) result.add(i+1);

        int[] answer = new int[result.size()];

        for(int i=0;i<answer.length;i++)
            answer[i] = result.get(i);

        return answer;
    }
}

```
