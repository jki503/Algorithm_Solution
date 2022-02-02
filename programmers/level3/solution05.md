# 프로그래머스 LEVEL 3 거스름돈

</br>

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12907?language=java)

</br>

```java

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] changes = new int[n+1];

        // 초기값 이용해서 증가
        changes[0] = 1;

        for(int i=0;i<money.length;i++){
            int m = money[i];

            for(int j=1;j<=n;j++){

                // 거슬러 줄 수 없으면
                if(j - m < 0 )
                    continue;

                changes[j] += (changes[j-m]);
            }
        }
        answer = changes[n] % 1000000007;
        return answer;
    }
}

```
