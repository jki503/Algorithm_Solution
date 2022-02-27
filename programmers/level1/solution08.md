# 프로그래머스 LEVEL 1 2019 카카오 개발자 겨울 인턴십 크레인 인형뽑기 게임

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/64061?language=java)

</br>

```java

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        int n = board.length;

        for(int mv : moves){

            for(int y=0;y<n;y++){

                int curr = board[y][mv-1];

                // 인형 발견
                if(curr != 0){

                    if(st.empty()) st.push(curr);
                    else{
                        if(st.peek() == curr){
                            st.pop();
                            answer+=2;
                        }
                        else st.push(curr);

                    }

                    board[y][mv-1] = 0;
                    break;
                }
            }

        }

        return answer;
    }
}

```
