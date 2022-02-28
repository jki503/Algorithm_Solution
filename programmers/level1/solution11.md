# 프로그래머스 LEVEL 1 K번째 수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42748?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int n = commands.length;

        int[] answer = new int[n];

        for(int i=0;i<n;i++){

            int start = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2]-1;

            int[] temp = Arrays.copyOfRange(array,start,end);
            Arrays.sort(temp);

            answer[i]  = temp[k];

        }


        return answer;
    }
}

```
