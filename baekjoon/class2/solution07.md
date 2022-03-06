# 백준 class 2 직사각형에서 탈출(1085)

- [문제 링크](https://www.acmicpc.net/problem/1085)

</br>

```java

import java.io.*;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.MAX_VALUE;

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        if(result > x)
            result = x;

        if(result > y)
            result = y;

        if(result > w - x)
            result = w - x;

        if(result > h - y)
            result = h - y;

        System.out.println(result);
    }

}

```
