# 프로그래머스 LEVEL 3 순위

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/49191?language=java)

</br>

```java

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] board = new boolean[n][n];

        for(int[] r : results){
            int winner = r[0] - 1;
            int loser = r[1] - 1;

            board[winner][loser] = true;
        }

        for(int k = 0 ; k < n; k++)
            for(int i = 0; i < n ; i++)
                for(int j = 0 ; j < n; j++){
                    if(i == j)
                        continue;

                    if(board[i][j])
                        continue;

                    board[i][j] = board[i][k] && board[k][j];
                }

        for(int y = 0 ; y < n; y++){

            int cnt = 0;
            for(int x = 0; x < n; x++){
                if(board[y][x] || board[x][y])
                    cnt++;
            }

            // 승패 합 결정 판단
            if(cnt == n-1)
                answer++;

        }

        return answer;
    }

}

```
