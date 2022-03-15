# 백준 class 3 1로 만들기(1463)

- [문제 링크](https://www.acmicpc.net/problem/1463)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=N;i++){

            if(i%2==0 && i%3==0) dp[i] = Math.min(dp[i-1],Math.min(dp[i/2],dp[i/3])) + 1;
            else if(i%2!=0 && i%3==0) dp[i]= Math.min(dp[i-1],dp[i/3])+1;
            else if(i%2==0 && i%3!=0) dp[i]= Math.min(dp[i-1],dp[i/2])+1;
            else dp[i] = dp[i-1]+1;

        }

        bw.write(dp[N]+"");
        bw.flush();
        bw.close();

    }

}

```
