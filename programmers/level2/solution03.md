# 프로그래머스 LEVEL 2 위클리 챌린지 피로도

</br>

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/87946?language=java)

</br>

```java
import java.lang.Math;
import java.util.Arrays;

class Solution {

    /*
    visited : 방문 여부
    n : 던전 길이
    */
    boolean[] visited;
    int n;
    int answer;

    public int solution(int k, int[][] dungeons) {

        answer = 0;
        n = dungeons.length;
        visited = new boolean[n];


        dfs(k,dungeons,0);

        return answer;
    }

    void dfs(int k, int[][] dungeons, int count){

        // 현재 피로도 갱신

        for(int i=0;i<n;i++){

            // 방문한 던전이면 continue;
            if(visited[i])
                continue;

            // 필요 피로도와 소모 피로도가 > k continue
            if(dungeons[i][0] > k || dungeons[i][1] > k)
                continue;

            visited[i] = true;
            dfs(k -dungeons[i][1] ,dungeons, count+1);
            visited[i] = false;
        }

        answer = Math.max(answer,count);
    }


}

```
