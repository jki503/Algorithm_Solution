# 프로그래머스 LEVEL 3 N으로 표현

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42895?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;

        List<Set<Integer>> cntList = new ArrayList<>();

        for(int i=0;i<8;i++)
            cntList.add(new HashSet<>());

        int num = 0;

        for(int i = 0 ; i < 8 ; i++){

            Set<Integer> currSet = cntList.get(i);

            num = num*10 + N; // N, NN, NNN
            currSet.add(num);

            for(int j = 0 ; j < i ; j++){

                for(int num1 : cntList.get(j)){

                    for(int num2 : cntList.get(i-j-1)){
                        currSet.add(num1 + num2);
                        currSet.add(num1 - num2);
                        currSet.add(num1 * num2);

                        // ArithmeticException 방지 / by zero
                        if(num2 !=0)
                            currSet.add(num1 / num2);
                    }
                }

            }

            // 체크
            if(currSet.contains(number)){
                answer= i + 1;
                break;
            }
        }

        return answer;
    }
}

```
