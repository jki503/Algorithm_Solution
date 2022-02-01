# 프로그래머스 LEVEL 2 2022 KAKAO BLIND RECRUITMENT K진수에서 소수 개수 구하기

</br>

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/92335)

</br>

```java

import java.util.StringTokenizer;
import java.lang.Math;

class Solution {

    public int solution(int n, int k) {

        int answer = 0;

        // k진수로 string 변환
        String convertNum =  ConvertNum(n,k);

        // 0을 기준으로 토큰 자르고 검사
        StringTokenizer st = new StringTokenizer(convertNum,"0");

        while(true){

            //token 없으면 break;
            if(!st.hasMoreTokens())
                break;

            String strNum = st.nextToken();

            // 1이면 continue;
            if(strNum == "1")
                continue;

            if(checkPrime(Long.parseLong(strNum)))
                answer++;
        }

        return answer;
    }

    public String ConvertNum(int num, int k){

        String result = "";

        while(true){

            // 탈출 조건
            if(num==0)
                break;

            result = Integer.toString(num % k)+ result;
            num/=k;
        }
        return result;
    }

    public boolean checkPrime(Long num){

        if(num < 2)
            return false;

        // for (int i=2; i*i <=num; i++)
        // -> 자료형 터져서 testcase1번 roop 갖히는 문제
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0)
                return false;
        }

        return true;
    }
}

```
