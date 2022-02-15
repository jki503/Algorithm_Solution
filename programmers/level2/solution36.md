# 프로그래머스 LEVEL 2 가장 큰 수

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42746?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> numList = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        // int[] -> List
        for(int n : numbers){
            numList.add(Integer.toString(n));
        }

        // 정렬
        Collections.sort(numList, (n1,n2)
                        -> (n2+n1).compareTo(n1+n2));

        // 문자열 붙이기
        for(String num : numList){
            result.append(num);
        }

        // 모든 원소 0 일경우 반례
        answer = result.toString().charAt(0) == '0' ? "0" : result.toString();

        return answer;
    }
}

```
