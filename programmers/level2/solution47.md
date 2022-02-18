# 프로그래머스 LEVEL 2 최댓값과 최솟값

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12939?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] strs = s.split(" ");
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<strs.length;i++)
            list.add(Integer.parseInt(strs[i]));

        answer = Collections.min(list) + " " + Collections.max(list);

        return answer;
    }
}

```
