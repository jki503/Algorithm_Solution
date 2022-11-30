# 프로그래머스 LEVEL 3 2020 KAKAO BLIND RECRUITMENT 블록 이동하기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/60063?language=java)

</br>

```java

import java.util.*;

class Solution {

    // 상 우 하 좌
    private static final int[] dx = {0, 1, 0, -1};

    private static final int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costs = new int[n][n][4];


        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0,1,0));
        while(!q.isEmpty()){
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int d = curr.direction;
            int cost = curr.cost;

            int xx = x + dx[d];
            int yy = y + dy[d];
            int dd = (d + 2) % 4;

            if(!(costs[y][x][d] == 0 && costs[yy][xx][dd] == 0)
               && (costs[y][x][d] <= cost && costs[yy][xx][dd] <= cost)){
                continue;
            }

            costs[y][x][d] = costs[yy][xx][dd] = cost;

            if((x == n - 1 && y == n - 1) || (xx == n - 1 && yy == n - 1)){
                continue;
            }


            for(int i = 0; i < 4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(!checkValid(nextX, nextY, d, board, n)){
                    continue;
                }

                q.offer(new Point(nextX, nextY, d, cost + 1));

            }

            for(int i = 1; i <= 3; i += 2){
                int nextD = (d + i) % 4;

                if(!checkValid(x, y, nextD, board, n) || !checkValid(xx, yy, nextD, board, n)){
                    continue;
                }

                q.offer(new Point(x, y, nextD, cost + 1));
                q.offer(new Point(xx, yy, nextD, cost + 1));
            }

        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            if(costs[n - 1][n - 1][i] == 0){
                continue;
            }

            answer = Math.min(answer, costs[n - 1][n - 1][i]);
        }

        return answer;
    }

    private class Point{

        int x;

        int y;

        int direction;

        int cost;

        public Point(int x, int y, int direction, int cost){
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }

    }


    private boolean checkValid(int x, int y, int d, int[][] board, int n){
        int xx = x + dx[d];
        int yy = y + dy[d];

        if(!checkIndex(x, y, n)){
            return false;
        }

        if(!checkIndex(xx, yy, n)){
            return false;
        }

        if(board[y][x] != 0 || board[yy][xx] != 0){

            return false;
        }

        return true;
    }

    private boolean checkIndex(int x, int y, int n){
        if(x < 0 || x >= n|| y < 0 || y >= n){
            return false;
        }

        return true;
    }
}
```
