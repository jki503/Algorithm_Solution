# 프로그래머스 LEVEL 3 Summer/Winter Coding(~2018) 숫자 게임

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12987?language=java)

</br>

```java

import java.util.PriorityQueue;


class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> Apq = new PriorityQueue<>();
        PriorityQueue<Integer> Bpq = new PriorityQueue<>();

        for(int i = 0 ; i< A.length; i++){
            Apq.offer(A[i]);
            Bpq.offer(B[i]);
        }

        while(!Bpq.isEmpty()){

            if(Apq.peek() < Bpq.poll()){
                Apq.poll(); // 이기면 A의 다음 원소로
                answer++;
            }
        }


        return answer;
    }
}

```
