# 프로그래머스 LEVEL 2 2018 KAKAO BLIND RECRUITMENT [3차] 파일명 정렬

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17686?language=java)

</br>

```java

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {

        // 사전순 HEAD 기준 -> NUM 기준
        Arrays.sort(files,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String[] f1 = detach(s1);
                String[] f2 = detach(s2);

                int headNum = f1[0].compareTo(f2[0]);

                if(headNum == 0){
                    return Integer.parseInt(f1[1]) - Integer.parseInt(f2[1]);
                }
                else{
                    return headNum;
                }
            }
        });


        String[] answer = files;

        return answer;
    }

    public String[] detach(String s){
        // Stringbuilder 이용
        StringBuilder head = new StringBuilder();
        StringBuilder num = new StringBuilder();

        int start = 0;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            if(curr >= '0' && curr <= '9'){
                num.append(curr);
            }
            else{
                // tail 영역이기 때문
                if(num.length() != 0){
                    break;
                }
                head.append(curr);
            }
        }

        // 대소문자 구분 X
        return new String[]{head.toString().toLowerCase(),num.toString()};
    }
}

```
