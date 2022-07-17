# leetcode 695. Max Area of Island

- [문제 링크](https://leetcode.com/problems/max-area-of-island/)

```java
import java.util.*;

class Solution {

    // 상우하좌
    int[] dirX = {0,1,0,-1};
    int[] dirY = {-1,0,1,0};

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int y = 0 ; y < row; y++){
            for(int x = 0 ; x < col; x++){
                if(grid[y][x] == 1){
                    result = Math.max(result, bfs(grid, y, x));
                }
            }
        }

        return result;
    }

    private int bfs(int[][] arr, int y, int x){
        int area = 0;;
        int row = arr.length;
        int col = arr[0].length;

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));

        while(!q.isEmpty()){
            Point curr = q.poll();
            int xx = curr.x;
            int yy = curr.y;

            if(xx < 0 || xx >= col || yy < 0 || yy >=row)
                continue;

            if(arr[yy][xx] != 1)
                continue;

            area++;
            arr[yy][xx] =0;

            for(int i = 0; i < 4; i++){
                q.offer(new Point(xx + dirX[i], yy + dirY[i]));
            }
        }

        return area;
    }


    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
```
