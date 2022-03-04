# 프로그래머스 LEVEL 2 2019 KAKAO BLIND RECRUITMENT 후보키

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42890?language=java)

</br>

```java

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Solution {

    public int solution(String[][] relation) {
        int answer = 0;

        int nRow = relation.length;
        int nCol = relation[0].length;

        List<Integer> ckList = new ArrayList<>(); // 조합 인덱스
        Set<String> keySet; // 후보키가 유일한지 체크

        for(int i= 1; i < (1<<nCol); i++){

            // 최소성 위반
            if(!checkMin(i,ckList))
                continue;

            // 유일성 검사
            keySet = new HashSet();

            for(int r=0;r < nRow;r++){

                StringBuilder sb = new StringBuilder();

                for(int c=0; c < nCol; c++)
                    if( (i & (1<<c)) > 0)
                       sb.append(relation[r][c]);

                keySet.add(sb.toString());
            }

            //유일성 위반
            if(keySet.size() != nRow)
                continue;

            ckList.add(i);
        }

        answer = ckList.size();

        return answer;
    }

    private boolean checkMin(int col, List<Integer> ckList){

        for(int ck : ckList)
            if( (ck & col) == ck){
                // col이 기존 후보키에 포함 되어있으면
                return false;
            }

        return true;
    }

}

```
