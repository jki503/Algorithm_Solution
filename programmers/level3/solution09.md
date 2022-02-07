# 프로그래머스 LEVEL 3 이중우선순위큐

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42628?language=java)

</br>

```java

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();

        for(String op : operations){

            // operand 설정
            StringTokenizer st = new StringTokenizer(op);

            char action = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(action == 'I'){
                // 추가 연산

                maxPq.offer(num);
                minPq.offer(num);

            }
            else if(action == 'D'){
                // 삭제 연산

                // 비어 있으면 continue;
                if(maxPq.isEmpty())
                    continue;

                if(num == 1){
                    //최대 삭제
                    int max = maxPq.poll();
                    minPq.remove(max);

                }
                else{
                    // 최소 삭제
                    int min = minPq.poll();
                    maxPq.remove(min);
                }

            }

        }

        if(!maxPq.isEmpty()){
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }

        return answer;
    }
}

```
