# 프로그래머스 LEVEL 2 2020 KAKAO BLIND RECRUITMENT 괄호 변환

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60058?language=java)

</br>

```java

import java.util.*;

class Solution {
    public String solution(String p) {
        // 1단계
        if(p.equals("")){
            return p;
        }

        //2단계
        int idx = getBoundaryIdx(p);
        String u = p.substring(0, idx);
        String v = "";
        if(idx != p.length()){
            v = p.substring(idx,p.length());
        }

        // 3단계
        if(isCorrect(u)){
            return u + solution(v);
        }

        // 4단계
        StringBuilder sb = new StringBuilder();
        sb.append('('.append(solution(v)).append(')'); // 4-1~4-3

        // 4-4
        for(int i = 1; i < u.length() - 1; i++){
            char c = u.charAt(i);

            if(c == '('){
                sb.append(')');
            }
            else{
                sb.append('(');
            }
        }

        //4-5
        return sb.toString();
    }

    private int getBoundaryIdx(String s){
        int openCnt = 0;
        int closeCnt = 0;

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                openCnt++;
            }
            else{
                closeCnt++;
            }

            if(openCnt == closeCnt){
                return i+1;
            }
        }

        return s.length();
    }

    private boolean isCorrect(String s){
        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }

                if(st.peek() == '('){
                    st.pop();
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}

```
