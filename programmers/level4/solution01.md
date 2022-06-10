# 프로그래머스 LEVEL 4 2020 KAKAO BLIND RECRUITMENT 가사 검색

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60060#)

</br>

- 이분 탐색
  - 다시 풀어봐야할 문제..

```java

import java.util.*;


class Solution {

    public int[] solution(String[] words, String[] queries) {

        int n = queries.length;
        int[] answer = new int[n];

        Map<Integer, List<String>> forwardMap = new HashMap<>();
        Map<Integer, List<String>> backwardMap = new HashMap<>();

        for(String word : words){
            int length = word.length();

            //길이에 따른 정방향, 역방향 맵 삽입
            forwardMap.computeIfAbsent(length, noOp -> new ArrayList<>()).add(word);
            backwardMap.computeIfAbsent(length, noOp -> new ArrayList<>()).add(reverseOrder(word));
        }

        for(int key : forwardMap.keySet()){
            // 정렬
            Collections.sort(forwardMap.get(key));
            Collections.sort(backwardMap.get(key));
        }

        for(int i = 0; i < n; i++){
            String query = queries[i];
            int length = query.length();

            List<String> tempList;
            if(query.charAt(0) == '?'){
                //접미면 reverse
                tempList = backwardMap.get(length);
                query = reverseOrder(query);
            }
            else{
                tempList = forwardMap.get(length);
            }

            if(tempList == null)
                answer[i] = 0;
            else
                answer[i] = lowerBound(tempList, query.replace('?','z')) - lowerBound(tempList, query.replace("?",""));
        }

        return answer;
    }

    private int lowerBound(List<String> list, String str){

        int start = 0;
        int end = list.size();
        int mid = 0;

        while(start < end){
            mid = (start + end) / 2;

            if(str.compareTo(list.get(mid)) <= 0){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }

        return start;
    }

    private String reverseOrder(String str){
        return new StringBuilder(str)
            .reverse()
            .toString();
    }

}

```
