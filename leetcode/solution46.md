# leetcode 130. Surrounded Regions

- [문제 링크](https://leetcode.com/problems/surrounded-regions/)

</br>

```java

class Solution {

    // up(0) right(1) down(2) left(3)
    private final int[] dirX= {0,1,0,-1};
    private final int[] dirY= {-1,0,1,0};

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        for(int y = 0; y < n; y++){

            if(board[y][0] == 'O')
                dfs(board,0,y);

            if(board[y][m-1] == 'O')
                dfs(board,m-1,y);
        }

        for(int x = 0; x < m; x++){

            if(board[0][x] == 'O')
                dfs(board,x,0);

            if(board[n-1][x] == 'O')
                dfs(board,x,n-1);
        }

        for(int y=0; y < n; y++)
            for(int x = 0 ; x < m; x++){

                if(board[y][x] == 'O')
                    board[y][x] = 'X';
                else if( board[y][x] == '.')
                    board[y][x] = 'O';

            }

    }

    public void dfs(char[][] board, int x, int y){

        board[y][x] = '.';

        for(int i = 0 ; i < 4; i++){

            int xx = x + dirX[i];
            int yy = y + dirY[i];

            if(xx < 0 || xx >= board[0].length || yy < 0 || yy >= board.length)
                continue;

            if(board[yy][xx] != 'O')
                continue;

            dfs(board,xx,yy);
        }
    }
}

```
