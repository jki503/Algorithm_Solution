# 프로그래머스 LEVEL 3 [2020 카카오 인턴십] 경주로 건설

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/67259?language=java)

```java

import java.util.*;

class Solution {
    //상(0) 우(1) 하(2) 좌(3)
    private static final int[] dx = new int[]{0,1,0,-1};

    private static final int[] dy = new int[]{-1,0,1,0};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] costs = new int[n][n][4];

        Queue<Point> q = new ArrayDeque<>();
        q.offer(new Point(0,0,1,0));
        q.offer(new Point(0,0,2,0));

        while(!q.isEmpty()){
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int direction = curr.direction;
            int cost = curr.cost;

            if(x < 0 || x >= n || y < 0 || y >= n || board[y][x] == 1){
                continue;
            }

            if(costs[y][x][direction] != 0 && costs[y][x][direction] <= cost){
                continue;
            }

            costs[y][x][direction] = cost;

            if(x == n - 1 && y == n - 1){
                continue;
            }

            int cornerDirection1 = (direction + 1) % 4;
            int cornerDirection2 = (direction + 3) % 4;

            q.offer(new Point(x + dx[direction], y + dy[direction], direction, cost + 100));
            q.offer(new Point(x + dx[cornerDirection1], y + dy[cornerDirection1], cornerDirection1, cost + 100 + 500));
            q.offer(new Point(x + dx[cornerDirection2], y + dy[cornerDirection2], cornerDirection2, cost + 100 + 500));

        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            if(costs[n-1][n-1][i] == 0){
                continue;
            }

            answer = Math.min(answer, costs[n-1][n-1][i]);
        }


        return answer;
    }

    class Point{

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
}

```
