# 프로그래머스 LEVEL 2 2018 KAKAO BLIND RECRUITMENT [1차] 뉴스 클러스터링

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17677?language=java)

</br>

```java

import java.util.ArrayList;
import java.util.List;

class Solution {
    int mul = 65536;

    public int solution(String str1, String str2) {
        int answer = 0;


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 집합 원소 넣기
        insertSet(list1, str1);
        insertSet(list2, str2);

        // 자카드 유사도 계산
        answer = calc(list1,list2);

        return answer;
    }

    public boolean checkAlpha(char c){
        if((c >= 'a' && c<='z')
           ||(c >= 'A' && c<='Z'))
                return true;

        return false;
    }

    // list에 각 집합의 원소 넣기
    public void insertSet(List<String> list, String s){
        StringBuilder sb;

        for(int i = 0;i < s.length() - 1;i++){
            sb = new StringBuilder();

            char first = s.charAt(i);
            char second = s.charAt(i+1);

            // 알파벳이 아닐 경우 버리기
            if(!checkAlpha(first) || !checkAlpha(second))
                continue;

            // 각문자 대문자로 변경후 add
            list.add(sb
                     .append(Character.toUpperCase(first))
                     .append(Character.toUpperCase(second))
                     .toString());
        }
    }

    public int calc(List<String> list1, List<String> list2){
        int size1 = list1.size();
        int size2 = list2.size();

        System.out.println(size1);
        System.out.println(size2);

        int count=0;

        if(size1 == 0){
            // 공집합
            if(size2 == 0){
                return mul*1;
            }
            else{
                return 0;
            }
        }
        else{
            if(size2 == 0){
                return 0;
            }
            else{
                for(String atom: list1){
                    // 교집합 개수
                    if(list2.contains(atom)){

                        // 추가되는 다중집합 검색 피하기
                        list2.remove(atom);
                        count++;
                    }
                }
            }
        }

        return  (mul * count) / (size1 + size2 - count);
    }
}

```
