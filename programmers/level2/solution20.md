# 프로그래머스 LEVEL 2 2018 KAKAO BLIND RECRUITMENT [1차] 뉴스 클러스터링

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17677?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int mul = 65536;

    public int solution(String str1, String str2) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 집합 원소 넣기
        setList(list1, str1);
        setList(list2, str2);

        int n1 = list1.size();
        int n2 = list2.size();

        int cnt = 0;

        if(n1 == 0 && n2 == 0)
            return mul; // 자카드 정의 X
        else if(n1 != 0 && n2 !=0){

            for(String value : list1){
                if(list2.contains(value)){
                    list2.remove(value);
                    cnt++;
                }
            }
        }
        else
            return 0;

        return (mul * cnt) / (n1 + n2 - cnt);
    }

    // list 설정
    private void setList(List<String> list, String s){
        StringBuilder sb;

        for(int i = 0;i < s.length() - 1;i++){
            sb = new StringBuilder();

            // 대문자 변환
            char first = Character.toUpperCase(s.charAt(i));
            char second = Character.toUpperCase(s.charAt(i+1));

            // 알파벳이 아닐 경우 버리기
            if(!checkAlpha(first) || !checkAlpha(second))
                continue;

            list.add(sb.append(first).append(second).toString());
        }
    }

    private boolean checkAlpha(char c){
        if(c >= 'A' && c<='Z')
            return true;

        return false;
    }
}

```
