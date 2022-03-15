# leetcode 62. Unique Paths

- [문제 링크](https://leetcode.com/problems/unique-paths/submissions/)

</br>

```java

class Solution {
    public int uniquePaths(int m, int n) {

        int[][] board = new int[m][n];

        for(int y=0;y<m;y++)
            board[y][0] = 1;

        for(int x=0;x<n;x++)
            board[0][x] = 1;

        for(int y=1;y<m;y++)
            for(int x=1;x<n;x++)
                board[y][x] = board[y-1][x] + board[y][x-1];

        return board[m-1][n-1];
    }
}

```
