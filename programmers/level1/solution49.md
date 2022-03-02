# 프로그래머스 LEVEL 1 평균 구하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12944?language=java)

</br>

```java

class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for(int n : arr)
            answer+=n;

        return answer / arr.length;
    }
}


```
