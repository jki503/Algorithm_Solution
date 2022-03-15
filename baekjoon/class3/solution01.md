# 백준 class 3 피보나치 함수(1003)

- [문제 링크](https://www.acmicpc.net/problem/1003)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] dp= new int[41][2];

        dp[0] = new int[]{1,0};
        dp[1] = new int[]{0,1};

        for(int i=2;i<=40;i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }


        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

}

```
