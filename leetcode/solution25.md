# leetcode Word Search

- [문제 링크](https://leetcode.com/problems/word-search/)

</br>

```java

class Solution {

    private boolean answer;
    private boolean[][] visited;

    // up right down left
    private static final int[] dirX ={0,1,0,-1};
    private static final int[] dirY ={-1,0,1,0};

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        visited = new boolean[n][m];

        for(int y=0;y<n;y++)
            for(int x=0;x<m;x++)
                if(board[y][x] == word.charAt(0))
                    dfs(x,y,0,board,word);


        return answer;
    }

    private void dfs(int x, int y, int idx, char[][] board, String word){

        if(idx == word.length()){
            answer = true;
            return;
        }

        if(y<0 || y >= board.length || x < 0 || x>=board[0].length)
            return;

        if(visited[y][x])
            return;

        if(word.charAt(idx) != board[y][x])
            return;

        for(int i=0; i < 4; i++){
            visited[y][x] = true;
            dfs(x+dirX[i],y+dirY[i],idx+1,board,word);
            visited[y][x] = false;
        }

    }


}

```
