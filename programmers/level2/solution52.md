# 프로그래머스 LEVEL 2 큰 수 만들기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42883?language=java)

</br>

```java

import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i < number.length();i++){

            char curr = number.charAt(i);

            // 지울 수 있을때
            while(!stack.empty() && stack.peek() < curr && k > 0){
                stack.pop();
                k--;
            }
            stack.push(curr);

        }

        // 뒷 부분 제거
        while(k!=0){
            stack.pop();
            k--;
        }

        while(!stack.empty())
            sb.insert(0,stack.pop());

        answer = sb.toString();

        return answer;
    }
}

```
