# 프로그래머스 LEVEL 1 나누어 떨어지는 숫자 배열

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12910?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> list = new ArrayList<>();

        for(int num : arr)
            if(num % divisor == 0)
                list.add(num);

        // 원소 없음
        if(list.size() == 0)
            return new int[]{-1};

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i);

        return answer;
    }
}

```
