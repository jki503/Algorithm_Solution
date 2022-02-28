# 프로그래머스 LEVEL 1 2018 KAKAO BLIND RECRUITMENT [1차] 다트 게임

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17682?language=java)

</br>

```java

class Solution {
    public int solution(String dartResult) {
        int answer = 0;


        int[] score = new int[3];

        int idx=0;
        int num = 0;

        for(int i=0 ; i < dartResult.length();i++){

            char c = dartResult.charAt(i);

            if(c >= '0' && c <= '9'){
                // number 체크
                if(dartResult.charAt(i+1) == '0'){
                    num = 10;
                    i++;
                }
                else
                    num = c - '0';
                continue;
            }
            else if(c == 'S') score[idx++] = num;
            else if(c == 'D') score[idx++] = (int)Math.pow(num,2);
            else if(c == 'T') score[idx++] = (int)Math.pow(num,3);
            else if(c == '*'){
                score[idx-1]*=2;
                if(idx>=2)
                    score[idx-2]*=2; // 두 번 이상이면
            }
            else if(c == '#')
                score[idx-1] = -score[idx-1];

            num=0;
        }

        for(int i=0; i < 3; i++)
            answer+=score[i];

        return answer;
    }
}

```
