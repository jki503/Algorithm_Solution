# 프로그래머스 LEVEL 2 2019 카카오 개발자 겨울 인턴십 튜플

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/64065?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(String s) {

        int[] answer = {};
        // 튜플 원소 담을 list
        List<Integer> list = new ArrayList<>();


        //처음 {{ 제거
        s = s.substring(2,s.length());

        // 뒤 }} 제거
        s = s.substring(0,s.length()-2);

        // },{ 을 공백으로 치환
        s = s.replace("},{", " ");

        // 튜플 배열로 변환
        String[] tuples = s.split(" ");

        //원소 길이 짧은 순으로 정렬
        Arrays.sort(tuples, new Comparator<String>(){

            public int compare(String t1, String t2){
                return t1.length() - t2.length();
           }
        });

        for(String tuple : tuples){

            // , 기준으로 split
            String[] atoms = tuple.split(",");

            for(String atom : atoms){

                int atomNum = Integer.parseInt(atom);

                // 원소 추가
                if(!list.contains(atomNum))
                    list.add(atomNum);
            }
        }

        answer = new int[list.size()];
        for(int i=0;i< list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}

```
