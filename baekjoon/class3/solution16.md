# 백준 class 3 경로찾기(11403)

- [문제 링크](https://www.acmicpc.net/problem/11403)

</br>

```java

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int y=0; y < N; y++) {
            String[] inputs = br.readLine().split(" ");

            for (int x = 0; x < N; x++)
                board[y][x] = Integer.parseInt(inputs[x]);
        }

        for(int k=0; k< N; k++)
            for(int i=0;i<N;i++)
                for(int j=0;j<N;j++)
                    if(board[i][k] == 1 && board[k][j] == 1)
                        board[i][j] = 1;

        StringBuilder sb = new StringBuilder();

        for(int y=0; y < N; y++){

            for(int x=0; x< N; x++)
                sb.append(board[y][x]).append(' ');

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}

```
