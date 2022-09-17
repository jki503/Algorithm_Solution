# 프로그래머스 LEVEL 1 2019 KAKAO BLIND RECRUITMENT 실패율

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42889?language=java)

</br>

```java
import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        int nPlayer = stages.length;
        int[] failUsers = new int[N + 1];

        for(int s : stages){
            failUsers[s - 1]++;
        }

        for(int i = 0; i < N; i++){
            if(nPlayer == 0 || failUsers[i] == 0){
                pq.offer(new Stage(i + 1,0));
            }
            else{
                pq.offer(new Stage(i + 1, (double)failUsers[i] / nPlayer));
            }
            nPlayer -= failUsers[i];
        }

        for(int i = 0 ; i < N; i++){
            answer[i] = pq.poll().num;
        }

        return answer;
    }

    class Stage implements Comparable<Stage>{
        int num;
        double fail;

        public Stage(int num, double fail){
            this.num = num;
            this.fail = fail;
        }

        @Override
        public int compareTo(Stage s){
            if(this.fail == s.fail){
                return this.num < s.num? -1 : 1;
            }

            return this.fail > s.fail ? -1 : 1;
        }
    }
}
```
