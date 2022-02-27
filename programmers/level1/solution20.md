# 프로그래머스 LEVEL 1 월간 코드 챌린지 시즌 1 두 개 뽑아서 더하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/68644?language=java)

</br>

```java

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] solution(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();

        // 두 개 수 덧셈 넣기
        int n = numbers.length;
        for(int i = 0 ; i < n; i++)
            for(int j=i+1; j < n; j++)
                set.add(numbers[i]+numbers[j]);

        int[] answer = new int[set.size()];
        int i=0;

        Iterator<Integer> iter = set.iterator();

        // set에서 모든 원소 반환
        while(iter.hasNext())
            answer[i++] = iter.next();

        // 정렬
        Arrays.sort(answer);

        return answer;
    }
}

```
