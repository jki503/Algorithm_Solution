# 프로그래머스 LEVEL 2 2020 KAKAO BLIND RECRUITMENT 문자열 압축

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60057?language=java)

</br>

```java

import java.lang.Math;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;

        StringBuilder sb;

        for(int i=1;i<=n/2; i++){

            /*
                token : 초기 토큰
                count : 초기 연속되는 토큰 개수
                sb : 압축한 임시 string
            */
            String token = s.substring(0,i);
            int count = 1;
            sb = new StringBuilder();

            for(int j=i;j<=n;j+=i){

                // index 터지는 거 방지
                int from = j;
                int to = j + i > n ? n : j+i;

                String curr = s.substring(from, to);

                if(curr.equals(token)){
                    // 같으면 개수 증가
                    count++;
                }
                else{
                    // 다르면
                    if(count > 1){
                        // count가 1보다 클 경우
                        sb.append(count);
                    }

                    // 토큰 추가하고, 갱신
                    sb.append(token);
                    count = 1;
                    token = curr;
                }
            }

            // 마지막 토큰 추가
            sb.append(token);

            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}

```
