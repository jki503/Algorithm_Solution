# leetcode 200. Number of Islands

- [문제 링크](https://leetcode.com/problems/number-of-islands/)

</br>

```java

import java.util.Queue;
import java.util.LinkedList;

class Solution {

    // up(0) right(1) down(2) left(3);
    private final int[] dirX = {0,1,0,-1};
    private final int[] dirY = {-1,0,1,0};

    public int numIslands(char[][] grid) {

        int landCnt = 0;

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '0')
                    continue;

                q.offer(new int[]{j,i});
                landCnt++;

                while(!q.isEmpty()){

                    int[] curr = q.poll();
                    int x = curr[0];
                    int y = curr[1];

                    if(x<0 || x>=m || y <0 || y>=n)
                        continue;

                    if(grid[y][x] == '0')
                        continue;

                    grid[y][x] = '0';

                    for(int d = 0; d < 4; d++)
                        q.offer(new int[]{x+dirX[d],y+dirY[d]});
                }
            }
        }

        return landCnt;

    }
}

```
