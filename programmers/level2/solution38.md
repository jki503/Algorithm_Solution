# 프로그래머스 LEVEL 2 월간 코드 챌린지 시즌2 2개 이하로 다른 비트

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/77885?language=java)

</br>

```java

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer = new long[numbers.length];

        for(int i = 0; i < numbers.length;i++){

            long curr = numbers[i];

            // 1의 자리가 0일때
            if( (curr & 1) == 0){
                answer[i] = curr + 1;
            }
            else{
                // 비트 1의 연속 찾기
                long bit = 1;

                while(true){
                    // 다른 비트
                    if( (curr & bit) == 0){
                        bit/=2;
                        break;
                    }
                    bit*=2;
                }

                answer[i] = curr + bit;
            }
        }

        return answer;
    }
}

```
