# [class2] 백준 7568 덩치

- [문제 링크](https://www.acmicpc.net/problem/7568)

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

        int N = Integer.parseInt(br.readLine());
        int[][] man = new int[N][2];

        // 배열 세팅
        for(int i = 0 ;i < N; i ++){

            st = new StringTokenizer(br.readLine());

            man[i][0] = Integer.parseInt(st.nextToken());
            man[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N ; i++){
            int rank=1;
            for(int j=0 ;j < N;j++){

                // 같은 사람이면 continue;
                if(i==j)
                    continue;

                // 비교 후 덩치가 작으면 rank 증가
                if(man[i][0] < man[j][0] && man[i][1] < man[j][1]){
                    rank++;
                }
            }
            // 현재 사람의 rank 기록
            sb.append(rank).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}

```
