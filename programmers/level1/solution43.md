# 프로그래머스 LEVEL 1 정수 내림차순으로 배치하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12933?language=java)

</br>

```java

import java.util.Arrays;

class Solution {
    public long solution(long n) {

        char[] nums = Long.toString(n).toCharArray();
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();

        for(char c : nums)
            sb.insert(0,c);

        long answer = Long.parseLong(sb.toString());

        return answer;
    }
}

```
