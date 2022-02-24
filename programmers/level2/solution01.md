# 프로그래머스 LEVEL 2 [찾아라 프로그래밍 마에스터] 게임맵 최단 거리

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/1844)

</br>

```java

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    // 상(0) 우(1) 하(2) 좌(3)
    int[] dirX = {0,1,0,-1};
    int[] dirY = {-1,0,1,0};

    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        int[][] costMap = new int[n][m];

        Queue<User> q = new LinkedList<>();

        // 초기 객체
        q.offer(new User(0,0,1));

        // 현재 블록을 기준으로 검사
        while(!q.isEmpty()){

            User curr = q.poll();

            int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;


            // 유효한 위치 판단
            if(!checkValid(y,x,n,m,maps))
                continue;

            // 최소 비용인지
            if(costMap[y][x] != 0 && costMap[y][x] <= cost)
                continue;

            costMap[y][x] = cost;

            // 도착했는지
            if(y == n-1 && x == m-1)
                continue;

            for(int i=0;i<4;i++)
                q.offer(new User(x+dirX[i], y+dirY[i], cost+1));

        }


        /* 다음 블록 기준으로 검사
        while(!q.isEmpty()){

            User curr = q.poll();

            int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;

            for(int i=0;i<4;i++){

                int nextX = x + dirX[i];
                int nextY = y + dirY[i];
                int nextCost = cost + 1;

                // 유효한 위치 판단
                if(!checkValid(nextY,nextX,n,m,maps))
                    continue;

                // 최소 비용 판단
                if(costMap[nextY][nextX] !=0 && costMap[nextY][nextX] <= nextCost)
                    continue;

                costMap[nextY][nextX] = nextCost;

                // 도착 인지
                if(nextY == n-1 && nextX == m-1)
                    continue;

                q.offer(new User(nextX,nextY,nextCost));
            }

        }*/

        answer = costMap[n-1][m-1] == 0 ? -1 : costMap[n-1][m-1];

        return answer;
    }

    public boolean checkValid(int y, int x, int n, int m, int[][] arr){

        if( y<0 || y >=n// row 검사
        || x<0 || x>=m // col 검사
        || arr[y][x] == 0) return false;// 벽 검사
        else
            return true;
    }

    class User{

        int x;
        int y;
        int cost;

        User(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
```
