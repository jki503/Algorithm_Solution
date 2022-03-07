# 백준 class 2 랜선 자르기(1654)

- [문제 링크](https://www.acmicpc.net/problem/1654)

</br>

```java

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];

        for(int i = 0; i < K; i++)
            lan[i] = Integer.parseInt(br.readLine());

        //1. 정렬
        Arrays.sort(lan);

        //2. 탐색
        long min = 0;
        long max = lan[K-1]+(long)1;
        long mid = 0;


        while(min < max){
            mid = (max + min) / 2;
            long cnt = 0;

            for(int i = 0 ; i < K; i++)
                cnt += (lan[i] / mid);

            if(cnt < N)
                max = mid;
            else
                min = mid + 1;

        }

        System.out.println(min-1);


    }

}

```
