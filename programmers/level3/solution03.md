# 프로그래머스 LEVEL 3 네트워크

</br>

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/43162?language=java)

</br>

```java
class Solution {

    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i = 0 ; i < n ; i++){

            // 방문한 네트워크면 continue;
            if(visited[i])
                continue;

            countNetwork(i, n, computers);
            answer++;
        }

        return answer;
    }

    void countNetwork(int start, int n, int[][] computers){
        visited[start] = true;

        for(int i = 0 ; i < n; i++){

            // 방문 되어있으면 - 같은 노드도 제외
            if(visited[i]) continue;

            //연결되어있지 않으면
            if(computers[start][i] == 0) continue;

            countNetwork(i,n,computers);
        }
    }
}

```
