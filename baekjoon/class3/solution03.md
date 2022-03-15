# 백준 class 3 Four Squares(17626)

- [문제 링크](https://www.acmicpc.net/problem/17626)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[1] = 1;

        for(int i=1; i <= N; i++){

            dp[i] = dp[i-1] + dp[1];

            for(int j=2; j*j<=i;j++)
                if(dp[i] > dp[i-j*j] + 1)
                    dp[i] =dp[i-j*j]+1;

        }

        bw.write(dp[N]+"");
        bw.flush();
        bw.close();
    }
}

```
