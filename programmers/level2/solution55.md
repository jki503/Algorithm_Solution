# 프로그래머스 LEVEL 2 가장 큰 정사각형 찾기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12905?language=java)

</br>

```java

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;

        int n = board.length;
        int m = board[0].length;

        if(n == 1 || m == 1)
            return 1;

        int max = 0;

        for(int y=1; y < n; y++){
            for(int x = 1 ;x < m; x++){

                if(board[y][x] == 0)
                    continue;

                int leftTop = board[y-1][x-1];
                int top = board[y-1][x];
                int left = board[y][x-1];

                int min = Math.min(leftTop, Math.min(top,left)); //이전 변의 길이
                board[y][x] = min + 1; // 갱신

                max = Math.max(min+1, max);
            }
        }

        answer = max * max;
        return answer;
    }
}

```
