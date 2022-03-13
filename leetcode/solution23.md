# leetcode 64. Minimum Path Sum

- [문제 링크](https://leetcode.com/problems/minimum-path-sum/submissions/)

</br>

```java

class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for(int y = 0; y < m; y++){
            for(int x = 0; x < n; x++){
                if(x==0 && y==0)
                    continue;
                else if(y == 0 && x != 0)
                    grid[y][x] += grid[y][x-1];
                else if(y != 0 && x == 0)
                    grid[y][x] += grid[y-1][x];
                else
                    grid[y][x] += Math.min(grid[y-1][x], grid[y][x-1]);

            }
        }


        return grid[m-1][n-1];
    }
}

```
