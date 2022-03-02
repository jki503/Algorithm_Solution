# 프로그래머스 LEVEL 1 제일 작은 수 제거 하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12935?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {

        if(arr.length <= 1)
            return new int[]{ -1 };

        int min = Arrays.stream(arr).min().getAsInt();

        int[] answer = new int[arr.length-1];
        int idx=0;

        for(int i =0 ; i < arr.length; i++){
            // 최소값은 continue;
            if(arr[i] == min){
                continue;
            }

            answer[idx++] = arr[i];
        }

        return answer;
    }
}


```
