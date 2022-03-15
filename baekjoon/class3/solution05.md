# 백준 class 3 팩토리얼 0의 개수(1676)

- [문제 링크](https://www.acmicpc.net/problem/1676)

</br>

```java

import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result=0;

        // 10의 개수
        while(N!=0){
            N/=5;
            result+=N;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

```
