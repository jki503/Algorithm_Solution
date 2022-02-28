# 프로그래머스 LEVEL 1 위클리 챌린지 최소직사각형

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/86491?language=java)

  </br>

```java

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int w = 0;
        int h = 0;

        // s[1] 을 세로 기준
        for(int[] s : sizes){

            if(s[0] > s[1]){
                w = s[0] > w ? s[0] : w;
                h = s[1] > h ? s[1] : h;
            }
            else{
                w = s[1] > w ? s[1] : w;
                h = s[0] > h ? s[0] : h;
            }

        }

        answer = w * h;

        return answer;
    }
}

```
