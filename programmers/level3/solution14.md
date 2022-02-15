# 프로그래머스 LEVEL 3 단속 카메라

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/42884?language=java)

</br>

```java

import java.util.Arrays;

class Solution {

    boolean[] visited;

    public int solution(int[][] routes) {
        int answer = 0;

        // 차가 나가는 순서대로
        Arrays.sort(routes, (r1,r2) -> r1[1] - r2[1]);

        visited = new boolean[routes.length];

        for(int i=0; i < routes.length ; i++){

            // 설치한 경로면
            if(visited[i])
                continue;

            int out = routes[i][1];

            // 탐색
            searchRoute(i,out,routes);
            answer++;

        }

        return answer;
    }

    public void searchRoute(int idx, int out, int[][] arr){

        visited[idx] = true;

        for(int i=0;i<arr.length;i++){

            if(visited[i])
                continue;

            // 범위에 있으면
            if(out >= arr[i][0] && out<= arr[i][1])
                searchRoute(i,out,arr);
        }
    }
}

```
