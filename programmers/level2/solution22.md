# 프로그래머스 LEVEL 2 2018 KAKAO BLIND RECRUITMENT [3차] 압축

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17684?language=java)

</br>

```java

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {

    HashMap<String,Integer> dict = new HashMap<>();

    public void initDict(){
        char curr = 'A';
        for(int i=1;i<=26;i++){
            dict.put(curr+"",i);
            curr++;
        }
    }

    public int[] solution(String msg) {
        int[] answer = {};
        int n = msg.length();

        List<Integer> list = new ArrayList<>();

        // 초기 사전
        initDict();

        // 추가할 사전 번호
        int num = 27;


        for(int i=0;i<n;i++){

            // 길이
            int j=1;
            for(j=1; i+j <= n ;j++){
                if(!dict.containsKey(msg.substring(i,i+j))){
                    // 길이 사전에 없으니까 줄이고 break;
                    j--;
                    break;
                }
            }

            // 마지막 원소 추가
            if(i+j>=n){
                list.add(dict.get(msg.substring(i)));
                break;
            }

            // w,c 구하기
            String w = msg.substring(i,i+j);
            String c = msg.charAt(i+j)+"";

            // 색인 번호 출력
            list.add(dict.get(w));

            // 사전 추가
            dict.put(w+c,num++);

            // 길이가 1보다 크면 index 점프
            if(j>1){
                i+=j-1;
            }
        }

        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }


        return answer;
    }

}

```
