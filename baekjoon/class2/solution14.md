# 백준 class 2 소수 찾기 (1978)

- [문제 링크](https://www.acmicpc.net/problem/1978)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int primeCnt = 0;

        String[] inputs = br.readLine().split(" ");

        for(int i=0; i < N; i++)
            if( checkPrime(Integer.parseInt(inputs[i]) ))
                primeCnt++;

        System.out.println(primeCnt);

    }

    private static boolean checkPrime(int num){

        if(num < 2)
            return false;

        for(int i=2;i<=Math.sqrt(num);i++)
            if(num % i == 0)
                return false;

        return true;
    }
}

```
