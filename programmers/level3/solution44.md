# 프로그래머스 LEVEL 3 2022 KAKAO BLIND RECRUITMENT 사라지는 발판

- [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92345)

```java
class Solution {

    // 상 우 하 좌
    private static final int[] dx = {-1,0,1,0};
    private static final int[] dy = {0,1,0,-1};

    private int defaultMin;
    private int row;
    private int col;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        row = board.length;
        col = board[0].length;
        defaultMin = row * col;

        Result result = dfs(new Player(aloc[1], aloc[0]), new Player(bloc[1], bloc[0]), 0, board);
        return result.count;
    }

    private Result dfs(Player one, Player another, int depth, int[][] board){
        boolean isWin = false;
        int min = defaultMin;
        int max = depth;

        int x = one.x;
        int y = one.y;

        if(board[y][x] == 1){
            for(int i = 0 ; i < dx.length; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];

                // 이동할 수 없는 상황
                if(!isValid(xx, yy, board)){
                    continue;
                }

                board[y][x] = 0;

                // 다음 턴의 플레이어 결과
                Result anotherResult = dfs(another, new Player(xx, yy), depth + 1, board);
                isWin |= !anotherResult.isWin;

                if(!anotherResult.isWin){
                    min = Math.min(min, anotherResult.count);
                }
                else{
                    max = Math.max(max, anotherResult.count);
                }


                board[y][x] = 1;
            }

        }

        return new Result(isWin, isWin ? min : max);

    }

    private boolean isValid(int x, int y, int[][] board){
        if(x < 0 || x >= col || y < 0 || y >= row || board[y][x] == 0){
            return false;
        }

        return true;
    }

    class Player{
        int x;
        int y;

        public Player(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    class Result{
        boolean isWin;
        int count;

        public Result(boolean isWin, int count){
            this.isWin = isWin;
            this.count = count;
        }
    }
}
```
