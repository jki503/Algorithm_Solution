# 프로그래머스 LEVEL 1 콜라츠 추측

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12943?language=java)

</br>

```java

class Solution {
    public int solution(int num) {
        int answer = 0;

        long coll = num;
        int cnt=0;

        while(true){

            if(coll == 1){
                answer = cnt;
                break;
            }

            if(cnt >= 500){
                answer = -1;
                break;
            }

            if(coll % 2 == 0)
                coll /=2;
            else
                coll = coll*3 + 1;

            cnt++;
        }

        return answer;
    }
}

```
