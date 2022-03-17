# 백준 class 3 계단 오르기

- [문제 링크](https://www.acmicpc.net/problem/2579)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];

        if(N>=2)
            dp[2] = arr[1]+arr[2];

        for(int i=3;i<=N;i++)
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1]) + arr[i];

        bw.write(dp[N]+"\n");
        bw.flush();
        bw.close();
    }

}


```
