# 백준 class 3 좌표 정렬하기(11650)

- [문제 링크](https://www.acmicpc.net/problem/11650)

</br>

```java

import java.io.*;
import java.util.Arrays;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            points[i][0] = Integer.parseInt(input[0]);
            points[i][1] = Integer.parseInt(input[1]);

        }

        Arrays.sort(points, (o1, o2)
                -> o1[0] == o2[0] ? o1[1] - o2[1]  : o1[0] - o2[0]);

        for(int[] point : points){
            bw.write(point[0] + " " + point[1] + "\n");
        }

        bw.flush();
        bw.close();
    }

}

```
