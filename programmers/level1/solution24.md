# 프로그래머스 LEVEL 1 위클리 챌린지 부족한 금액 계산하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/82612?language=java)

</br>

```java

class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;

        for(int i=1 ;  i <= count; i++){

            int fee = price * i;


            if(money < fee){
                // 요금이 부족한 경우
                answer += (fee - money);
                money=0;
            }else
                money-=fee;

        }


        return answer;
    }
}

```
