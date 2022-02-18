# 프로그래머스 LEVEL 2 월간 코드 챌린지 시즌 1 이진 변환 반복하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/70129?language=java)

</br>

```java


class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int cntOne = 0;
        int cntZero = 0;
        int cntRepeat = 0;

        while(!s.equals("1")) {

            cntOne = 0;

            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == '0') cntZero++;
                else cntOne++;

            s = Integer.toBinaryString(cntOne);

            cntRepeat++;
        }

        answer[0] = cntRepeat;
        answer[1] = cntZero;

        return answer;
    }
}

```
