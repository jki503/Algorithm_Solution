# 백준 class 2 체스판 다시 칠하기(1018)

- [문제 링크](https://www.acmicpc.net/problem/1018)

</br>

```java

import java.io.*;
import java.util.StringTokenizer;

class Main{

    private static final int SIZE = 64;

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[N][M];

        for(int y = 0; y < N ; y++){
            String inputRow = br.readLine();

            for(int x = 0 ; x < M ; x++)
                if(inputRow.charAt(x) == 'W')
                    board[y][x] = true;
        }

        int min = SIZE;

        // 2. 탐색
        for(int i = 0; i < N - 7; i++){
            for(int j = 0 ; j < M - 7; j++){

                boolean currColor = board[i][j];
                int cnt = 0;

                for(int y = i ; y < i + 8; y++){
                    for(int x = j ; x < j + 8; x++){

                        if(currColor != board[y][x])
                            cnt++;

                        currColor = (!currColor);
                    }
                    currColor = (!currColor);
                }

                // 갱신
                cnt = Math.min(SIZE - cnt, cnt);
                if(min > cnt)
                    min = cnt;
            }
        }

        System.out.println(min);

    }

}

```
