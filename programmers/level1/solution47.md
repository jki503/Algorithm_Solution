# 프로그래머스 LEVEL 1 최대공약수와 최소공배수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12940?language=java)

</br>

```java

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int gcd = getGcd(n,m);

        answer[0] = gcd;
        answer[1] = n * m / gcd;

        return answer;
    }

    private int getGcd(int n, int m){

        int temp = 0;

        while(n!=0){

            temp = n;
            n = m % n;
            m = temp;

        }

        return m;
    }
}

```
