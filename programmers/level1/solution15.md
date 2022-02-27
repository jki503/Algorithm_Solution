# 프로그래머스 LEVEL 1 2019 KAKAO BLIND RECRUITMENT 실패율

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42889?language=java)

</br>

```java

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] users = new int[N];
        int nPlayers = stages.length;
        List<FailRate> stageList = new ArrayList<>();

        // 스테이지에 있는 유저
        for(int s : stages){
            if(s > N)
                continue;
            users[s-1] +=1;
        }

        // 실패율 저장
        for(int i=0;i<users.length;i++){
            double fail = 0;

            if(users[i] == 0)
                fail = 0;
            else{
                fail = (double)users[i] / nPlayers;
                nPlayers -= users[i];
            }

            stageList.add(new FailRate(i+1,fail));
        }

        // 정렬
        Collections.sort(stageList);

        for(int i=0;i<N;i++)
            answer[i] = stageList.get(i).idx;

        return answer;
    }

    class FailRate implements Comparable<FailRate>{

        int idx;
        double per;

        FailRate(int idx, double per){
            this.idx = idx;
            this.per = per;
        }

        @Override
        public int compareTo(FailRate s){

            if(this.per == s.per)
                return this.idx < s.idx ? -1 : 1; // idx 오름 차순

            return this.per > s.per ? -1 : 1; // 실패율 내림차순
        }
    }
}

```
