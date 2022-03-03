# 프로그래머스 LEVEL 2 조이스특

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42860?language=java)

</br>

```java

class Solution {
    public int solution(String name) {

        int answer = 0;
        int n = name.length();

        int idx = 0; // A가 연속되지 않는 위치
        int mv = n-1; // 좌우 움직임
        for(int i=0;i<n;i++){

            // 상하
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속되는 A구간으로 좌우 값 판단.
            idx = i+1;
            while(idx < n && name.charAt(idx) == 'A')
                idx++;

            //좌우값 갱신
            mv = Math.min(mv,(n-idx)*2 +i);
            mv = Math.min(mv,i*2+n-idx);
        }

        answer+=mv;

        return answer;
    }
}




```
