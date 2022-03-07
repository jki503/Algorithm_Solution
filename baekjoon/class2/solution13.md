# 백준 class 2 소수 구하기(1929)

- [문제 링크](https://www.acmicpc.net/problem/1929)

</br>

```java

import java.io.*;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=M ; i <= N; i++)
            if(checkPrime(i))
                sb.append(i).append("\n");

        System.out.println(sb.toString());

    }

    private static boolean checkPrime(int num){

        if(num < 2)
            return false;

        for(int i=2; i <= Math.sqrt(num); i++)
            if(num % i == 0)
                return false;

        return true;
    }

}

```
