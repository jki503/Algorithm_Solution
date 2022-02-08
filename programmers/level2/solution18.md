# 프로그래머스 LEVEL 2 2020 KAKAO BLIND RECRUITMENT 괄호 변환

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60058?language=java)

</br>

```java

import java.util.Stack;

class Solution {

    public String solution(String p) {
        String answer = "";

        // 1번
        if(p == null || checkCorrect(p))
            return p;

        //2번
        int idx = findIndex(p);
        int n = p.length();

        String u=p.substring(0,idx+1);
        String v = "";
        if(idx + 1 != n){
            v = p.substring(idx+1,n);
        }

        String resultV = solution(v);

        // 3번
        if(checkCorrect(u)){
            // 3-1
            answer = u + resultV;

        }
        else{
        // 4번
        StringBuilder sb = new StringBuilder();
            sb.append('(') // 4-1
                .append(resultV) // 4-2
                .append(')'); // 4-3

            // 4-4
            for(int i=1;i<u.length()-1;i++){
                char curr = u.charAt(i);

                if(curr == '(')
                    sb.append(')');
                else
                    sb.append('(');
            }

            // 4-5
            answer = sb.toString();
        }

        return answer;
    }

    // 올바른 문자열인지
    public boolean checkCorrect(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);

            if(curr == '(')
                stack.push(curr);
            else{
                // 비어 있으면
                if(stack.empty())
                    return false;
                if(stack.peek() != '(')
                    return false;

                stack.pop();
            }
        }

        if(stack.empty())
            return true;
        else
            return false;
    }

    // u,v 구분 인덱스
    public int findIndex(String w){
        int open = 0;
        int close =0;
        int idx=0;

        for(int i=0;i<w.length();i++){
            char curr = w.charAt(i);

            if(curr == '(')
                open++;
            else
                close++;

            if(open == close){
                idx = i;
                break;
            }
        }
        return idx;

    }
}

```
