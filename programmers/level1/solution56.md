# 2022 KAKAO TECH INTERNSHIP 성격 유형 검사하기

- [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/118666)

```java
import java.util.*;

class Solution {

    private static final String[] personType = new String[]{"RT", "CF", "JM", "AN"};

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> pointMap = new HashMap<>();

        int n = survey.length;
        for(int i = 0; i < n; i++){
            String s = survey[i];
            int choice = choices[i];

            if(choice == 4){
                continue;
            }

            if(choice < 4){
                char ch = s.charAt(0);
                pointMap.put(ch, pointMap.getOrDefault(ch, 0) + 4 - choice);
                continue;
            }

            char ch = s.charAt(1);
            pointMap.put(ch, pointMap.getOrDefault(ch, 0) + choice - 4);

        }

        StringBuilder sb = new StringBuilder();
        for(String type : personType){
            char first = type.charAt(0);
            char second = type.charAt(1);
            sb.append(pointMap.getOrDefault(first, 0) >= pointMap.getOrDefault(second, 0) ? first : second);
        }

        return sb.toString();
    }
}
```
