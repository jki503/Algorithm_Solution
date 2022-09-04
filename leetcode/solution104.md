# leetcode 1091. Shortest Path in Binary Matrix

- [문제 링크](https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/)

```java
import java.util.*;

class Solution {

    // 상 우 하 좌 상우 상좌 하우 하좌
    int dx[] = {0,1,0,-1,1,-1,1,-1};
    int dy[] = {-1,0,1,0,-1,-1,1,1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new Point(0,0,1));

        while(!q.isEmpty()){
            Point curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int distance = curr.distance;

            if(!isValid(x, y, n, grid)){
                continue;
            }

            if(visited[y][x]){
                continue;
            }

            if(x == n - 1 && y == n - 1 && answer > distance){
                answer = distance;
                break;
            }

            visited[y][x] = true;


            for(int i = 0 ; i < dx.length; i++){
                q.offer(new Point(x + dx[i], y + dy[i], distance +1));
            }
        }

        if(answer == Integer.MAX_VALUE){
            return -1;
        }

        return answer;
    }

    private boolean isValid(int x, int y, int n, int[][] grid){
        if(x < 0 || x >= n || y < 0 || y >= n || grid[y][x] != 0){
            return false;
        }

        return true;
    }

    class Point{
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
```
