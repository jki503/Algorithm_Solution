# 프로그래머스 LEVEL 2 2017 팁스타운 짝지어 제거하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12973?language=java)

</br>

```java

import java.util.Stack;
import java.util.Arrays;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        // 문자열 배열
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<charArr.length;i++){
            char curr = charArr[i];


            if(stack.empty()){
                // 비어있으면 push
                stack.push(curr);
            }
            else{
                if(stack.peek() == curr){
                    // 같으면 제거
                    stack.pop();
                }
                else{
                    stack.push(curr);
                }
            }

        }

        // 스택 비어있으면
        if(stack.empty())
            answer = 1;

        return answer;
    }
}

```
