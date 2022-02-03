# [class2] 백준 10250 ACM호텔

- [문제 링크](https://www.acmicpc.net/problem/10250)

</br>

```java

import java.io.*;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            // 나누어 떨어질 경우 조건
            int floor = N % H ==0 ? H : N % H;
            int unit = N % H ==0 ? (N / H): (N / H)  + 1;

            // 호수가 한 자리일경우
            if(unit < 10){
                sb.append(floor).append(0).append(unit);
            }
            else{
                sb.append(floor).append(unit);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}

```
