# 프록그래머스 LEVEL 1 2020 카카오 인턴십 키패드 누르기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/67256?language=java)

</br>

```java

class Solution {

    private final int RIGHT = 0;
    private final int LEFT = 1;

    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder padSb = new StringBuilder();

        // 초기 위치
        int l = 10;
        int r = 12;

        for(int n : numbers){

            int point = 0;;

            // 왼손 오른손 정하기
            if(n == 1 || n == 4 || n == 7) point = LEFT;
            else if( n == 3 || n == 6 || n == 9) point = RIGHT;
            else{
                n = n == 0 ? 11 : n; // 0 위치를 11로

                int rDist = Math.abs(n - r);
                int lDist = Math.abs(n - l);

                rDist = rDist%3 + rDist/3;
                lDist = lDist%3 + lDist/3;

                // 거리 판단
                if(rDist > lDist)
                    point = LEFT;
                else if(rDist < lDist)
                    point = RIGHT;
                else{
                    if(hand.equals("right"))
                        point = RIGHT;
                    else
                        point = LEFT;
                }
            }

            // 결과 넣기
            if(point == LEFT){
                l = n ;
                padSb.append('L');
            }
            else{
                r = n ;
                padSb.append('R');
            }

        }

        answer = padSb.toString();

        return answer;
    }
}

```
