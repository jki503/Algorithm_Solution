# 프로그래머스 LEVEL 2 2018 KAKAO BLIND RECRUITMENT [1차] 캐시

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/17680?language=java)

</br>

```java

import java.util.LinkedList;

class Solution {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();

        // city 개수
        int n = cities.length;
        String[] citiesUpper = new String[n];


        // 실수 : 대소문자 구분 없음
        for(int i=0;i<n;i++){
            citiesUpper[i] = cities[i].toUpperCase();
        }

        if(cacheSize==0){
            answer = 5 * n;
        }
        else{
            for(String city : citiesUpper){

                if(list.remove(city)){
                    //cache hit
                    list.add(city);
                    answer+=1;
                }
                else{
                    // cache miss
                    if(list.size() == cacheSize){
                        // 사이즈 넘어가면 LRU
                        list.remove(0);
                    }
                    list.add(city);
                    answer+=5;
                }
            }
        }

        return answer;
    }
}

```
