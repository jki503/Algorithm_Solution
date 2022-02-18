# 프로그래머스 LEVEL 2 H-Index

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42747?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int n = citations.length;

        for(int i=0;i<n;i++){
            int h = n - i;

            if(citations[i] >=h){
                answer = h;
                break;
            }
        }


        return answer;
    }
}

```
