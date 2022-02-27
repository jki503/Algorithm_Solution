# 프로그래머스 LEVEL 3 베스트 앨범

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42579?language=java)

</br>

```java

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String,Integer> gMap = new HashMap<>();

        for(int i=0;i<genres.length;i++)
            gMap.put(genres[i], gMap.getOrDefault(genres[i],0) + plays[i]);

        // 1. 합을 기준으로 장르 정렬
        List<Entry<String,Integer>> orderedList = new ArrayList<>(gMap.entrySet());

        Collections.sort(orderedList, new Comparator<Entry<String,Integer>>(){

            @Override
            public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2){
                if(e1.getValue() > e2.getValue())
                    return -1;
                else
                    return 1;
            }

        });

        List<Integer> bestAlbum = new ArrayList<>();

        // 2. 장르에서 베스트 두 개
        for(Entry<String,Integer> entry : orderedList){

            List<Music> list = new ArrayList<>();

            for(int i=0; i < genres.length;i++){
                if(entry.getKey().equals(genres[i]))
                    list.add(new Music(plays[i],i));
            }

            Collections.sort(list);

            bestAlbum.add(list.get(0).idx);

            //2개 넣을 수 있으면
            if(list.size()>=2)
                bestAlbum.add(list.get(1).idx);

        }

        int[] answer = new int[bestAlbum.size()];

        for(int i=0;i<answer.length;i++)
            answer[i] = bestAlbum.get(i);

        return answer;
    }

    class Music implements Comparable<Music>{

        int play;
        int idx;

        Music(int play, int idx){
            this.play = play;
            this.idx = idx;
        }

        @Override
        public int compareTo(Music music){

            if(this.play ==  music.play){
                return this.idx - music.idx; // index 오름차순
            }else
                return music.play - this.play; // play 내림차순

        }
    }

}

```
