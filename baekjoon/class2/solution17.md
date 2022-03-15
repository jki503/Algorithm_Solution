# 백준 class 2 벌집(2292)

- [문제 링크](https://www.acmicpc.net/problem/2292)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        N-=1;
        int result = 1;
        int i = 1;

        while(N>0){
            result++;
            N -= i*6;
            i++;
        }

        System.out.println(result);

    }

}

```
