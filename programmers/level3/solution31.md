# 프로그래머스 LEVEL 3 월간 코드 챌린지 시즌 2 110 옮기기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/77886?language=java)

</br>

```java

import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];


        for(int i=0;i<s.length;i++){

            Stack<Character> st = new Stack<>();
            int cnt = 0;

            // 110 지우기
            for(char c : s[i].toCharArray()){

                switch(c){
                    case '1':
                        st.push(c);
                        break;
                    case '0':
                        if(st.size()>=2){
                            char second = st.pop();
                            char first = st.pop();

                            if(first == '1' && second =='1')
                                cnt++;
                            else{
                                st.push(first);
                                st.push(second);
                                st.push(c);
                            }
                        }
                        else
                            st.push(c);
                        break;
                    default : break;
                }
            }

            // 0 뒤에 붙이기
            StringBuilder sb = new StringBuilder();
            int idx = st.size(); // 110 넣을 위치
            boolean checkZero = false; // zero 위치 찾기

            while(!st.empty()){
                char curr = st.pop();

                //0 위치 찾기
                if(!checkZero){
                    if(curr == '1') idx--;
                    else checkZero = true;
                }

                sb.insert(0,curr);
            }

            for(int j=0;j<cnt;j++)
                sb.insert(idx,"110");

            answer[i] = sb.toString();
        }

        return answer;
    }
}

```
