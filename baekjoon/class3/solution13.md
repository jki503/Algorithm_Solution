# 백준 class 3 구간 합 구하기 4(11659)

- [문제 링크](https://www.acmicpc.net/problem/11659)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N+1];

        input = br.readLine().split(" ");

        for(int i=1; i < N+1; i++)
            arr[i] = Integer.parseInt(input[i-1]);

        for(int i=1; i < N + 1; i++)
            arr[i] += arr[i-1];

        for(int i=0; i < M; i++) {

            input = br.readLine().split(" ");

            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);

            bw.write(arr[to] - arr[from - 1]+"\n");

        }

        bw.flush();
        bw.close();
    }

}

```
