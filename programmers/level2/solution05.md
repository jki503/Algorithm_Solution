# 프로그래머스 LEVEL 2 2022 KAKAO BLIND RECRUITMENT K진수에서 소수 개수 구하기

</br>

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/92335)

</br>

```java

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while(n!=0){
            sb.insert(0, n % k);
            n /= k;
        }
        String numStr = sb.toString().replaceAll("^0+|0+$","");
        String[] maybePrimes = numStr.split("0+");

        for(String maybePrime : maybePrimes){
            if(isPrime(Long.parseLong(maybePrime))){
                answer++;
            }
        }
        return answer;
    }

    private boolean isPrime(long num){
        if(num < 2){
            return false;
        }

        for(int i = 2 ; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
```
