# 프로그래머스 LEVEL 1 소수 찾기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12921?language=java)

</br>

```java

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=2;i<=n;i++)
            if(checkPrime(i))
                answer++;

        return answer;
    }

    private boolean checkPrime(int num){

        for(int i = 2 ; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }

        return true;
    }
}

```
