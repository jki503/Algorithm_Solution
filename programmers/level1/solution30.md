# 프로그래머스 LEVEL 1 2018 KAKAO BLIND RECRUITMENT [1차] 다트 게임

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17682?language=java)

</br>

```java

class Solution {
    public int solution(String dartResult) {
        int[] points = new int[3];

        int idx = 0;
        for(int i = 0 ; i < dartResult.length(); i++){
            char c = dartResult.charAt(i);
            if(c >= '0' && c <= '9'){
                if(dartResult.charAt(i + 1) == '0'){
                    points[idx++] = 10;
                    i++;
                }
                else{
                    points[idx++] = c - '0';
                }
                continue;
            }

            switch(c){
                case 'D': points[idx-1] = (int)Math.pow(points[idx-1],2);
                    break;
                case 'T': points[idx-1] = (int)Math.pow(points[idx-1],3);
                    break;
                case '*':
                    points[idx-1] *= 2;
                    if(idx -2 >= 0){
                        points[idx-2] *= 2;
                    }
                    break;
                case '#':
                    points[idx-1] *= -1;
                    break;
                default: break;
            }
        }

        int answer = 0;
        for(int point : points){
            answer += point;
        }

        return answer;
    }
}
```
