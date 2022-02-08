# 프로그래머스 Summer/Winter Coding(~2018) 영어 끝말잇기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12981?language=java)

</br>

```java

import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {

        HashSet<String> hist = new HashSet<>();

        // default
        int[] answer = {0,0};

        // 초기 사람, 라운드, 단어
        int man = 2;
        int round = 1;
        String prev = words[0];
        hist.add(prev);

        for(int i=1;i<words.length;i++){
            // 현재 단어에 끝 문자
            char end = prev.charAt(prev.length()-1);
            String curr = words[i];

            // 끝글자로 시작 안하거나 이력이 있으면
            if(!curr.startsWith(end+"") || hist.contains(curr)){
                answer[0] = man;
                answer[1] = round;
                break;
            }

            // 이력 추가
            hist.add(curr);

            //사람과 라운드 변경
            man = man+1 > n ? (man+1)%n : man+1;
            round = man == 1 ? round+1 : round;

            // 단어 변경
            prev = curr;
        }

        return answer;
    }
}

```
