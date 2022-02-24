# 프로그래머스 LEVEL 2 올바른 괄호

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12909?language=java)

</br>

```java

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){

            if(c == '(')
                stack.push(c);
            else{
                if(stack.empty()){
                    answer = false;
                    break;
                }
                else
                    stack.pop();
            }
        }

        if(!stack.empty())
            answer = false;

        return answer;
    }
}

```
