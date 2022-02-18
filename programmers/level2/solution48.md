# 프로그래머스 LEVEL 2 다음 큰 숫자

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12911?language=java)

</br>

```java

class Solution {
    public int solution(int n) {
        int answer = 0;

        int bitCnt = getBit(n);


        int i=1;
        while(true){

            if(bitCnt == getBit(n+i)){
                answer = n + i;
                break;
            }
            i++;
        }


        return answer;
    }

    public int getBit(int n){

        int cnt=0;
        int bit = 1;
        while(n > bit){
            if( (n & bit) > 0)
                cnt++;
            bit = bit << 1;
        }

        return cnt;
    }
}

```
