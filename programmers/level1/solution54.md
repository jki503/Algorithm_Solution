# 프로그래머스 LEVEL 1 직사각형 별찍기

- [문제 링크](https://programmers.co.kr/learn/courses/30/lessons/12969?language=java)

</br>

- buffer

</br>

```java

import java.io.*;
import java.util.StringTokenizer;

class Solution {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++)
                sb.append('*');

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}


```

</br>

- Scanner

```java

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 0; i < b; i++){
            for(int j = 0 ; j < a; j++)
                System.out.print("*");

            System.out.println();
        }

    }
}

```
