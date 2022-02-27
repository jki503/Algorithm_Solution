# 프로그래머스 LEVEL 1 찾아라 프로그래밍 마에스터 폰켓몬

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/1845?language=java)

</br>

```java

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2; // 최대 선택

        HashSet<Integer> monSet = new HashSet<>();

        for(int n: nums)
            monSet.add(n);

        if(monSet.size() < answer) // 종류가 더 적을 경우
            answer = monSet.size();

        return answer;
    }
}

```
