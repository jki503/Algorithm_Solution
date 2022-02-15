# 프로그래머스 LEVEL 3 Summer/Winter Coding(~2018) 기지국 설치

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12979?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;

class Solution {

    // 한 개의 기지국의 범위
    int scope;

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        scope = 2*w + 1;

        int start = 1;
        for(int s : stations){

            /*
                앞쪽 유효한 기지국
                뒤쪽 유효한 기지국
            */
            int front = s - w;
            int back = s + w;

            // start부터 기지국 세울 필요 없으면
            if(front <= start){
                start = back + 1;
                continue;
            }

            // 기지국 계산
            answer += calc(start,front-1);
            start = back + 1;
        }

        // 기지국 계산
        if(start <= n){
            answer += calc(start,n);
        }


        return answer;
    }

    public int calc(int start, int end){

        // 올림 연산
        int result = (end - start + 1) / scope ;
        if( (end-start+1) % scope != 0)
            result+=1;


        return result;

    }
}

```
