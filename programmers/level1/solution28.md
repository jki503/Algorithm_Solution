# 프로그래머스 LEVEL 1 같은 숫자는 싫어

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12906?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for(int i=1; i < arr.length;i++){
            if(arr[i-1] == arr[i])
                continue;

            list.add(arr[i]);
        }


        int[] answer = new int[list.size()];

        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i);


        return answer;
    }
}

```
